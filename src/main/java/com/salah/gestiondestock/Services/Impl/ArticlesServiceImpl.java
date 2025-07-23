package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeFournisseurDto;
import com.salah.gestiondestock.Dtos.LigneVenteDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalidOperationException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.ArticlesRepository;
import com.salah.gestiondestock.Repositories.LigneCommadeFournisseurRepository;
import com.salah.gestiondestock.Repositories.LigneCommandeClientRepository;
import com.salah.gestiondestock.Services.ArticlesService;
import com.salah.gestiondestock.Validators.ArticleValidator;
import com.salah.gestiondestock.model.Articles;
import com.salah.gestiondestock.model.LigneCommandeClient;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.stream.Collectors;

import com.salah.gestiondestock.Repositories.LigneVentesRepository;
import com.salah.gestiondestock.model.LigneCommandeFournisseur;
import com.salah.gestiondestock.model.LigneVente;

@Service
@Slf4j
@NoArgsConstructor
@AllArgsConstructor
public class ArticlesServiceImpl implements ArticlesService {

    private static final Logger log = LoggerFactory.getLogger(ArticlesServiceImpl.class);

  private ArticlesRepository articleRepository;
  private LigneVentesRepository venteRepository;
  private LigneCommadeFournisseurRepository commandeFournisseurRepository;
  private LigneCommandeClientRepository commandeClientRepository;



  @Override
  public ArticlesDto save(ArticlesDto dto) {
    List<String> errors = ArticleValidator.validate(dto);
    if (!errors.isEmpty()) {
      log.error("Article is not valid {}", dto);
      throw new InvalideEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALID, errors);
    }

    return ArticlesDto.fromEntity(
        articleRepository.save(
            ArticlesDto.toEntity(dto)
        )
    );
  }

  @Override
  public ArticlesDto findById(Integer id) {
    if (id == null) {
      log.error("Article ID is null");
      return null;
    }

    return articleRepository.findById(id).map(ArticlesDto::fromEntity).orElseThrow(() ->
        new EntityNotFoundException(
            "Aucun article avec l'ID = " + id + " n' ete trouve dans la BDD",
            ErrorCodes.ARTICLE_NOT_FOUND)
    );
  }

  @Override
  public ArticlesDto findByCodeArticle(String codeArticle) {
    if (!StringUtils.hasLength(codeArticle)) {
      log.error("Article CODE is null");
      return null;
    }

    return articleRepository.findArticlesByCodeArticle(codeArticle)
        .map(ArticlesDto::fromEntity)
        .orElseThrow(() ->
            new EntityNotFoundException(
                "Aucun article avec le CODE = " + codeArticle + " n' ete trouve dans la BDD",
                ErrorCodes.ARTICLE_NOT_FOUND)
        );
  }

  @Override
  public List<ArticlesDto> findAll() {
    return articleRepository.findAll().stream()
        .map(ArticlesDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
    return venteRepository.findAllByArticle(idArticle).stream()
        .map(LigneVenteDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle) {
    return commandeClientRepository.findAllByArticle(idArticle).stream()
        .map(LigneCommandeClientDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
    return commandeFournisseurRepository.findAllByArticle(idArticle).stream()
        .map(LigneCommandeFournisseurDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public List<ArticlesDto> findAllArticleByIdCategory(Integer idCategory) {
    return articleRepository.findAllByCategory(idCategory).stream()
        .map(ArticlesDto::fromEntity)
        .collect(Collectors.toList());
  }

  @Override
  public void delete(Integer id) {
    if (id == null) {
      log.error("Article ID is null");
      return;
    }
    List<LigneCommandeClient> ligneCommandeClients = commandeClientRepository.findAllByArticle(id);
    if (!ligneCommandeClients.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes client", ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }
    List<LigneCommandeFournisseur> ligneCommandeFournisseurs = commandeFournisseurRepository.findAllByArticle(id);
    if (!ligneCommandeFournisseurs.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des commandes fournisseur",
          ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }
    List<LigneVente> ligneVentes = venteRepository.findAllByArticle(id);
    if (!ligneVentes.isEmpty()) {
      throw new InvalidOperationException("Impossible de supprimer un article deja utilise dans des ventes",
          ErrorCodes.ARTICLE_ALREADY_IN_USE);
    }
    articleRepository.deleteById(id);
  }
}
