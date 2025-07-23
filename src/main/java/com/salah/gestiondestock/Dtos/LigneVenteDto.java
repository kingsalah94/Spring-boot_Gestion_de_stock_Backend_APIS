package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import com.salah.gestiondestock.model.LigneVente;

@Data
@Builder
public class LigneVenteDto {

    private Integer id;
    private VentesDto ventesDto;

    private ArticlesDto article;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;

    private Integer idEntreprise;


    public static LigneVenteDto fromEntity(LigneVente ligneVente) {
    if (ligneVente == null) {
      return null;
    }

    return LigneVenteDto.builder()
        .id(ligneVente.getId())
        .ventesDto(VentesDto.fromEntity(ligneVente.getVente()))
        .article(ArticlesDto.fromEntity(ligneVente.getArticle()))
        .quantite(ligneVente.getQuantite())
        .prixUnitaire(ligneVente.getPrixUnitaire())
        .idEntreprise(ligneVente.getIdEntreprise())
        .build();
  }

  public static LigneVente toEntity(LigneVenteDto dto) {
    if (dto == null) {
      return null;
    }
    LigneVente ligneVente = new LigneVente();
    ligneVente.setId(dto.getId());
    ligneVente.setVente(VentesDto.toEntity(dto.getVentesDto()));
    ligneVente.setArticle(ArticlesDto.toEntity(dto.getArticle()));
    ligneVente.setQuantite(dto.getQuantite());
    ligneVente.setPrixUnitaire(dto.getPrixUnitaire());
    ligneVente.setIdEntreprise(dto.getIdEntreprise());
    return ligneVente;
  }
}
