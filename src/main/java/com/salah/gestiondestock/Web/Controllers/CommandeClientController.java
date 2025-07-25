package com.salah.gestiondestock.Web.Controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.salah.gestiondestock.Dtos.CommandClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Enums.EtatCommande;
import com.salah.gestiondestock.Services.CommandeClientService;
import com.salah.gestiondestock.Web.Api.CommandeClientApi;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@RestController
public class CommandeClientController implements CommandeClientApi {

  private CommandeClientService commandeClientService;

 @Autowired
  public CommandeClientController(CommandeClientService commandeClientService) {
    this.commandeClientService = commandeClientService;
  }
  @Override
  public ResponseEntity<CommandClientDto> save(CommandClientDto dto) {
    return ResponseEntity.ok(commandeClientService.save(dto));
  }

  @Override
  public ResponseEntity<CommandClientDto> updateEtatCommande(Integer idCommande, EtatCommande etatCommande) {
    return ResponseEntity.ok(commandeClientService.updateEtatCommande(idCommande, etatCommande));
  }

  @Override
  public ResponseEntity<CommandClientDto> updateQuantiteCommande(Integer idCommande, Integer idLigneCommande, BigDecimal quantite) {
    return ResponseEntity.ok(commandeClientService.updateQuantiteCommande(idCommande, idLigneCommande, quantite));
  }

  @Override
  public ResponseEntity<CommandClientDto> updateClient(Integer idCommande, Integer idClient) {
    return ResponseEntity.ok(commandeClientService.updateClient(idCommande, idClient));
  }

  @Override
  public ResponseEntity<CommandClientDto> updateArticle(Integer idCommande, Integer idLigneCommande, Integer idArticle) {
    return ResponseEntity.ok(commandeClientService.updateArticle(idCommande, idLigneCommande, idArticle));
  }

  @Override
  public ResponseEntity<CommandClientDto> deleteArticle(Integer idCommande, Integer idLigneCommande) {
    return ResponseEntity.ok(commandeClientService.deleteArticle(idCommande, idLigneCommande));
  }

  @Override
  public ResponseEntity<CommandClientDto> findById(Integer id) {
    return ResponseEntity.ok(commandeClientService.findById(id));
  }

  @Override
  public ResponseEntity<CommandClientDto> findByCode(String code) {
    return ResponseEntity.ok(commandeClientService.findByCode(code));
  }

  @Override
  public ResponseEntity<List<CommandClientDto>> findAll() {
    return ResponseEntity.ok(commandeClientService.findAll());
  }

  @Override
  public ResponseEntity<List<LigneCommandeClientDto>> findAllLignesCommandesClientByCommandeClientId(Integer idCommande) {
    return ResponseEntity.ok(commandeClientService.findAllLignesCommandesClientByCommandeClientId(idCommande));
  }

  @Override
  public ResponseEntity<Void> delete(Integer id) {
    commandeClientService.delete(id);
    return ResponseEntity.ok().build();
  }

}
