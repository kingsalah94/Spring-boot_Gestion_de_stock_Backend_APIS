package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;


@Data
public class ArticlesDto {

  private Integer id;

  private String codeArticle;

  private String designation;

  private BigDecimal prixUnitaireHt;

  private BigDecimal tauxTva;

  private BigDecimal prixUnitaireTtc;

  private String photo;

  private CategoryDto category;

  private Integer idEntreprise;
}
