package com.salah.gestiondestock.Dtos;

import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
public class LigneCommandeClientDto {

    private Integer id;
    private ArticlesDto articlesDto;
    
    @JsonIgnore
    private CommandClientDto commandClientDto;

    private BigDecimal prixUnitaire;

    private BigDecimal quantite;

    private Integer idEntreprise;
}
