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
    private BigDecimal prixUnitaireTtc;
    private BigDecimal tauxTva;
    private String photo;
    private CategoryDto category;
}
