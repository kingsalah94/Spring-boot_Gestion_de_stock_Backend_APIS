package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

import com.salah.gestiondestock.model.Articles;


@Data
@Builder
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

  public static ArticlesDto fromEntity(Articles article) {
    if (article == null) {
      return null;
    }
    return ArticlesDto.builder()
        .id(article.getId())
        .codeArticle(article.getCodeArticle())
        .designation(article.getDesignation())
        .photo(article.getPhoto())
        .prixUnitaireHt(article.getPrixUnitaireHt())
        .prixUnitaireTtc(article.getPrixUnitaireTtc())
        .tauxTva(article.getTauxTva())
        .idEntreprise(article.getIdEntreprise())
        .category(CategoryDto.fromEntity(article.getCategory()))
        .build();
  }

  public static Articles toEntity(ArticlesDto articlesDto) {
    if (articlesDto == null) {
      return null;
    }
    Articles article = new Articles();
    article.setId(articlesDto.getId());
    article.setCodeArticle(articlesDto.getCodeArticle());
    article.setDesignation(articlesDto.getDesignation());
    article.setPhoto(articlesDto.getPhoto());
    article.setPrixUnitaireHt(articlesDto.getPrixUnitaireHt());
    article.setPrixUnitaireTtc(articlesDto.getPrixUnitaireTtc());
    article.setTauxTva(articlesDto.getTauxTva());
    article.setIdEntreprise(articlesDto.getIdEntreprise());
    article.setCategory(CategoryDto.toEntity(articlesDto.getCategory()));
    return article;
  }
}
