package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class LigneVenteDto {

    private Integer id;
    private VentesDto ventesDto;

    private BigDecimal quantite;

    private BigDecimal prixUnitaire;
}
