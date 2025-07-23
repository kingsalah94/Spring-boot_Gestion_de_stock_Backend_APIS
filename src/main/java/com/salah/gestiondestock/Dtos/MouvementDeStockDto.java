package com.salah.gestiondestock.Dtos;

import com.salah.gestiondestock.Enums.SourceMouvementStock;
import com.salah.gestiondestock.Enums.TypeMouvementStock;
import com.salah.gestiondestock.model.MouvementDeStock;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
@Builder
public class MouvementDeStockDto {
    private Integer id;
    
    private Instant dateMouvement;

    private BigDecimal quantite;

    private ArticlesDto articlesDto;

    private TypeMouvementStock typeMouvementStock;

    private SourceMouvementStock sourceMouvementStock;

    private Integer idEntreprise;


public static MouvementDeStockDto fromEntity(MouvementDeStock mvtStk) {
    if (mvtStk == null) {
      return null;
    }

    return MouvementDeStockDto.builder()
        .id(mvtStk.getId())
        .dateMouvement(mvtStk.getDateMouvement())
        .quantite(mvtStk.getQuantite())
        .articlesDto(ArticlesDto.fromEntity(mvtStk.getArticles()))
        .typeMouvementStock(mvtStk.getTypeMvt())
        .sourceMouvementStock(mvtStk.getSourceMvt())
        .idEntreprise(mvtStk.getIdEntreprise())
        .build();
  }

  public static MouvementDeStock toEntity(MouvementDeStockDto dto) {
    if (dto == null) {
      return null;
    }

    MouvementDeStock mvtStk = new MouvementDeStock();
    mvtStk.setId(dto.getId());
    mvtStk.setDateMouvement(dto.getDateMouvement());
    mvtStk.setQuantite(dto.getQuantite());
    mvtStk.setArticles(ArticlesDto.toEntity(dto.getArticlesDto()));
    mvtStk.setTypeMvt(dto.getTypeMouvementStock());
    mvtStk.setSourceMvt(dto.getSourceMouvementStock());
    mvtStk.setIdEntreprise(dto.getIdEntreprise());
    return mvtStk;
  }
}


