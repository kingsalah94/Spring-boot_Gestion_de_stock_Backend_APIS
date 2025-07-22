package com.salah.gestiondestock.Dtos;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Data;

@Data
public class LigneCommandeFournisseurDto {

    private Integer id;
    private ArticlesDto articlesDto;

    private BigDecimal quantite;

  private BigDecimal prixUnitaire;

  private Integer idEntreprise;


    private CommandFournisseurDto commandFournisseurDto;
}
