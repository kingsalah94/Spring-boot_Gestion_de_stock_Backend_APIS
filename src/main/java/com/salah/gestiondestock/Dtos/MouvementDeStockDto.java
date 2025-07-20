package com.salah.gestiondestock.Dtos;

import com.salah.gestiondestock.Enums.TypeMouvementStock;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;
import java.time.Instant;

@Data
public class MouvementDeStockDto {
    private Integer id;
    private Instant dateMouvement;

    private BigDecimal quantite;

    private ArticlesDto articlesDto;

    private TypeMouvementStock typeMouvementStock;
}
