package com.salah.gestiondestock.Dtos;

import java.math.BigDecimal;

import com.salah.gestiondestock.model.LigneCommandeFournisseur;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LigneCommandeFournisseurDto {

    private Integer id;
    private ArticlesDto articlesDto;

    private BigDecimal quantite;

  private BigDecimal prixUnitaire;

  private Integer idEntreprise;


    private CommandFournisseurDto commandFournisseurDto;

    public static LigneCommandeFournisseurDto fromEntity(LigneCommandeFournisseur ligneCommandeFournisseur) {
    if (ligneCommandeFournisseur == null) {
      return null;
    }
    return LigneCommandeFournisseurDto.builder()
        .id(ligneCommandeFournisseur.getId())
        .articlesDto(ArticlesDto.fromEntity(ligneCommandeFournisseur.getArticle()))
        .quantite(ligneCommandeFournisseur.getQuantite())
        .prixUnitaire(ligneCommandeFournisseur.getPrixUnitaire())
        .idEntreprise(ligneCommandeFournisseur.getIdEntreprise())
        .build();
  }

  public static LigneCommandeFournisseur toEntity(LigneCommandeFournisseurDto dto) {
    if (dto == null) {
      return null;
    }

    LigneCommandeFournisseur ligneCommandeFournisseur = new LigneCommandeFournisseur();
    ligneCommandeFournisseur.setId(dto.getId());
    ligneCommandeFournisseur.setArticle(ArticlesDto.toEntity(dto.getArticlesDto()));
    ligneCommandeFournisseur.setPrixUnitaire(dto.getPrixUnitaire());
    ligneCommandeFournisseur.setQuantite(dto.getQuantite());
    ligneCommandeFournisseur.setIdEntreprise(dto.getIdEntreprise());
    return ligneCommandeFournisseur;
  }
}
