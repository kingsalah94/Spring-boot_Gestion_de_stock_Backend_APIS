package com.salah.gestiondestock.model;

import com.salah.gestiondestock.Enums.SourceMouvementStock;
import com.salah.gestiondestock.Enums.TypeMouvementStock;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.Instant;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "MouvementDeStocks")
public class MouvementDeStock extends AbstractEntity{

    @Column(name = "dateMouvement")
    private Instant dateMouvement;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Articles articles;

    @Column(name = "typemvt")
    @Enumerated(EnumType.STRING)
    private TypeMouvementStock typeMvt;

    @Column(name = "sourcemvt")
    @Enumerated(EnumType.STRING)
    private SourceMouvementStock sourceMvt;

    @Column(name = "identreprise")
    private Integer idEntreprise;}
