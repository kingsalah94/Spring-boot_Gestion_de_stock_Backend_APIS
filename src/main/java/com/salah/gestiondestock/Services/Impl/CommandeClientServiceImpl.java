package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Dtos.ClientDto;
import com.salah.gestiondestock.Dtos.CommandClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Dtos.MouvementDeStockDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Enums.EtatCommande;
import com.salah.gestiondestock.Enums.SourceMouvementStock;
import com.salah.gestiondestock.Enums.TypeMouvementStock;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalidOperationException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.ArticlesRepository;
import com.salah.gestiondestock.Repositories.ClientRepository;
import com.salah.gestiondestock.Repositories.CommandClientRepository;
import com.salah.gestiondestock.Repositories.LigneCommandeClientRepository;
import com.salah.gestiondestock.Repositories.MouvementDeStockRepository;
import com.salah.gestiondestock.Services.CommandeClientService;
import com.salah.gestiondestock.Services.MouvementStockService;
import com.salah.gestiondestock.Validators.ArticleValidator;
import com.salah.gestiondestock.Validators.CommandeClientValidator;
import com.salah.gestiondestock.model.Articles;
import com.salah.gestiondestock.model.Client;
import com.salah.gestiondestock.model.CommandClient;
import com.salah.gestiondestock.model.LigneCommandeClient;
import com.salah.gestiondestock.model.MouvementDeStock;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
public class CommandeClientServiceImpl implements CommandeClientService {

   private CommandClientRepository commandeClientRepository;
  private LigneCommandeClientRepository ligneCommandeClientRepository;
  private ClientRepository clientRepository;
  private ArticlesRepository articleRepository;
  private MouvementStockService mvtStkService;

  

  @Override
  public CommandClientDto save(CommandClientDto dto) {

    List<String> errors = CommandeClientValidator.validate(dto);

    if (!errors.isEmpty()) {
      log.error("Commande client n'est pas valide");
      throw new InvalideEntityException("La commande client n'est pas valide", ErrorCodes.COMMANDE_CLIENT_NOT_VALID, errors);
    }

    if (dto.getId() != null && dto.isCommandeLivree()) {
      throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }

    Optional<Client> client = clientRepository.findById(dto.getClientDto().getId());
    if (client.isEmpty()) {
      log.warn("Client with ID {} was not found in the DB", dto.getClientDto().getId());
      throw new EntityNotFoundException("Aucun client avec l'ID" + dto.getClientDto().getId() + " n'a ete trouve dans la BDD",
          ErrorCodes.CLIENT_NOT_FOUND);
    }

    List<String> articleErrors = new ArrayList<>();

    if (dto.getLigneCommandeClientDtos() != null) {
      dto.getLigneCommandeClientDtos().forEach(ligCmdClt -> {
        if (ligCmdClt.getArticlesDto() != null) {
          Optional<Articles> article = articleRepository.findById(ligCmdClt.getArticlesDto().getId());
          if (article.isEmpty()) {
            articleErrors.add("L'article avec l'ID " + ligCmdClt.getArticlesDto().getId() + " n'existe pas");
          }
        } else {
          articleErrors.add("Impossible d'enregister une commande avec un aticle NULL");
        }
      });
    }

    if (!articleErrors.isEmpty()) {
      log.warn("");
      throw new InvalideEntityException("Article n'existe pas dans la BDD", ErrorCodes.ARTICLE_NOT_FOUND, articleErrors);
    }
    dto.setDateCommande(Instant.now());
    CommandClient savedCmdClt = commandeClientRepository.save(CommandClientDto.toEntity(dto));

    if (dto.getLigneCommandeClientDtos() != null) {
      dto.getLigneCommandeClientDtos().forEach(ligCmdClt -> {
        LigneCommandeClient ligneCommandeClient = LigneCommandeClientDto.toEntity(ligCmdClt);
        ligneCommandeClient.setCommandClient(savedCmdClt);
        ligneCommandeClient.setIdEntreprise(dto.getIdEntreprise());
        LigneCommandeClient savedLigneCmd = ligneCommandeClientRepository.save(ligneCommandeClient);

        effectuerSortie(savedLigneCmd);
      });
    }

    return CommandClientDto.fromEntity(savedCmdClt);
  }

  @Override
  public CommandClientDto findById(Integer id) {
    if (id == null) {
      log.error("Commande client ID is NULL");
      return null;
    }
    return commandeClientRepository.findById(id)
        .map(CommandClientDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune commande client n'a ete trouve avec l'ID " + id, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
        ));
  }

  @Override
  public CommandClientDto findByCode(String code) {
    if (!StringUtils.hasLength(code)) {
      log.error("Commande client CODE is NULL");
      return null;
    }
    return commandeClientRepository.findCommandClientByCode(code)
        .map(CommandClientDto::fromEntity)
        .orElseThrow(() -> new EntityNotFoundException(
            "Aucune commande client n'a ete trouve avec le CODE " + code, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND
        ));
  }

  @Override
  public List<CommandClientDto> findAll() {
    return commandeClientRepository.findAll().stream()
        .map(CommandClientDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Commande client ID is NULL");
      return;
    }
    List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandClient(id);
    if (!ligneCommandeClients.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer une commande client deja utilisee",
          ErrorCodes.COMMANDE_CLIENT_ALREADY_IN_USE);
    }
    commandeClientRepository.deleteById(id);
  }

  @Override
  public List<LigneCommandeClientDto> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
    return ligneCommandeClientRepository.findAllByCommandClient(idCommande).stream()
        .map(LigneCommandeClientDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public CommandClientDto updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
    checkIdCommande(idCommande);
    if (!StringUtils.hasLength(String.valueOf(etatCommande))) {
      log.error("L'etat de la commande client is NULL");
      throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un etat null",
          ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }
    CommandClientDto commandeClient = checkEtatCommande(idCommande);
    commandeClient.setEtatCommande(etatCommande);

    CommandClient savedCmdClt = commandeClientRepository.save(CommandClientDto.toEntity(commandeClient));
    if (commandeClient.isCommandeLivree()) {
      updateMvtStk(idCommande);
    }

    return CommandClientDto.fromEntity(savedCmdClt);
  }

  @Override
  public CommandClientDto updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
    checkIdCommande(idCommande);
    checkIdLigneCommande(idLigneCommande);

    if (quantite == null || quantite.compareTo(BigDecimal.ZERO) == 0) {
      log.error("L'ID de la ligne commande is NULL");
      throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec une quantite null ou ZERO",
          ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }

    CommandClientDto commandeClient = checkEtatCommande(idCommande);
    Optional<LigneCommandeClient> ligneCommandeClientOptional = findLigneCommandeClient(idLigneCommande);

    LigneCommandeClient ligneCommandeClient = ligneCommandeClientOptional.get();
    ligneCommandeClient.setQuantite(quantite);
    ligneCommandeClientRepository.save(ligneCommandeClient);

    return commandeClient;
  }

  @Override
  public CommandClientDto updateClient(Integer idCommande, Integer idClient) {
    checkIdCommande(idCommande);
    if (idClient == null) {
      log.error("L'ID du client is NULL");
      throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un ID client null",
          ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }
    CommandClientDto commandeClient = checkEtatCommande(idCommande);
    Optional<Client> clientOptional = clientRepository.findById(idClient);
    if (clientOptional.isEmpty()) {
      throw new EntityNotFoundException(
          "Aucun client n'a ete trouve avec l'ID " + idClient, ErrorCodes.CLIENT_NOT_FOUND);
    }
    commandeClient.setClientDto(ClientDto.fromEntity(clientOptional.get()));

    return CommandClientDto.fromEntity(
        commandeClientRepository.save(CommandClientDto.toEntity(commandeClient))
    );
  }

  @Override
  public CommandClientDto updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
    checkIdCommande(idCommande);
    checkIdLigneCommande(idLigneCommande);
    checkIdArticle(idArticle, "nouvel");

    CommandClientDto commandeClient = checkEtatCommande(idCommande);

    Optional<LigneCommandeClient> ligneCommandeClient = findLigneCommandeClient(idLigneCommande);

    Optional<Articles> articleOptional = articleRepository.findById(idArticle);
    if (articleOptional.isEmpty()) {
      throw new EntityNotFoundException(
          "Aucune article n'a ete trouve avec l'ID " + idArticle, ErrorCodes.ARTICLE_NOT_FOUND);
    }

    List<String> errors = ArticleValidator.validate(ArticlesDto.fromEntity(articleOptional.get()));
    if (!errors.isEmpty()) {
      throw new InvalideEntityException("Article invalid", ErrorCodes.ARTICLE_NOT_VALID, errors);
    }

    LigneCommandeClient ligneCommandeClientToSaved = ligneCommandeClient.get();
    ligneCommandeClientToSaved.setArticles(articleOptional.get());
    ligneCommandeClientRepository.save(ligneCommandeClientToSaved);

    return commandeClient;
  }

  @Override
  public CommandClientDto deleteArticle(Integer idCommande, Integer idLigneCommande) {
    checkIdCommande(idCommande);
    checkIdLigneCommande(idLigneCommande);

    CommandClientDto commandeClient = checkEtatCommande(idCommande);
    // Just to check the LigneCommandeClient and inform the client in case it is absent
    findLigneCommandeClient(idLigneCommande);
    ligneCommandeClientRepository.deleteById(idLigneCommande);

    return commandeClient;
  }

  private CommandClientDto checkEtatCommande(Integer idCommande) {
    CommandClientDto commandeClient = findById(idCommande);
    if (commandeClient.isCommandeLivree()) {
      throw new InvalidOperationException("Impossible de modifier la commande lorsqu'elle est livree", ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }
    return commandeClient;
  }

  private Optional<LigneCommandeClient> findLigneCommandeClient(Integer idLigneCommande) {
    Optional<LigneCommandeClient> ligneCommandeClientOptional = ligneCommandeClientRepository.findById(idLigneCommande);
    if (ligneCommandeClientOptional.isEmpty()) {
      throw new EntityNotFoundException(
          "Aucune ligne commande client n'a ete trouve avec l'ID " + idLigneCommande, ErrorCodes.COMMANDE_CLIENT_NOT_FOUND);
    }
    return ligneCommandeClientOptional;
  }

  private void checkIdCommande(Integer idCommande) {
    if (idCommande == null) {
      log.error("Commande client ID is NULL");
      throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un ID null",
          ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }
  }

  private void checkIdLigneCommande(Integer idLigneCommande) {
    if (idLigneCommande == null) {
      log.error("L'ID de la ligne commande is NULL");
      throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec une ligne de commande null",
          ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }
  }

  private void checkIdArticle(Integer idArticle, String msg) {
    if (idArticle == null) {
      log.error("L'ID de " + msg + " is NULL");
      throw new InvalidOperationException("Impossible de modifier l'etat de la commande avec un " + msg + " ID article null",
          ErrorCodes.COMMANDE_CLIENT_NON_MODIFIABLE);
    }
  }

  private void updateMvtStk(Integer idCommande) {
    List<LigneCommandeClient> ligneCommandeClients = ligneCommandeClientRepository.findAllByCommandClient(idCommande);
    ligneCommandeClients.forEach(lig -> {
      effectuerSortie(lig);
    });
  }

  private void effectuerSortie(LigneCommandeClient lig) {
    MouvementDeStockDto mvtStkDto = MouvementDeStockDto.builder()
        .articlesDto(ArticlesDto.fromEntity(lig.getArticles()))
        .dateMouvement(Instant.now())
        .typeMouvementStock(TypeMouvementStock.SORTIE)
        .sourceMouvementStock(SourceMouvementStock.COMMANDE_CLIENT)
        .quantite(lig.getQuantite())
        .idEntreprise(lig.getIdEntreprise())
        .build();
    mvtStkService.sortieStock(mvtStkDto);
  }
}
