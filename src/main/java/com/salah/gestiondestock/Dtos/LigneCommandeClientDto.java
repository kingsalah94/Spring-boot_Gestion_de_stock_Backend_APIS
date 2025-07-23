package com.salah.gestiondestock.Dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salah.gestiondestock.model.LigneCommandeClient;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeClientDto {

    private Integer id;
    private ArticlesDto articlesDto;
    
    @JsonIgnore
    private CommandClientDto commandClientDto;

    private BigDecimal prixUnitaire;

    private BigDecimal quantite;

    private Integer idEntreprise;

    public static LigneCommandeClientDto fromEntity(LigneCommandeClient ligneCommandeClient) {
    if (ligneCommandeClient == null) {
      return null;
    }
    return LigneCommandeClientDto.builder()
        .id(ligneCommandeClient.getId())
        .articlesDto(ArticlesDto.fromEntity(ligneCommandeClient.getArticles()))
        .quantite(ligneCommandeClient.getQuantite())
        .prixUnitaire(ligneCommandeClient.getPrixUnitaire())
        .idEntreprise(ligneCommandeClient.getIdEntreprise())
        .build();
  }

  public static LigneCommandeClient toEntity(LigneCommandeClientDto dto) {
    if (dto == null) {
      return null;
    }

    LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
    ligneCommandeClient.setId(dto.getId());
    ligneCommandeClient.setArticles(ArticlesDto.toEntity(dto.getArticlesDto()));
    ligneCommandeClient.setPrixUnitaire(dto.getPrixUnitaire());
    ligneCommandeClient.setQuantite(dto.getQuantite());
    ligneCommandeClient.setIdEntreprise(dto.getIdEntreprise());
    return ligneCommandeClient;
  }
}
