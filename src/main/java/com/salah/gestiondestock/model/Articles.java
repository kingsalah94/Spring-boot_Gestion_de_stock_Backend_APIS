package com.salah.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Articles")
public class Articles extends AbstractEntity{

    @Column(name = "codearticle")
    private String codeArticle;

    @Column(name = "designation")
    private String designation;

    @Column(name = "prixunitaireht")
    private BigDecimal prixUnitaireHt;

    @Column(name = "tauxtva")
    private BigDecimal tauxTva;

    @Column(name = "prixunitairettc")
    private BigDecimal prixUnitaireTtc;

    @Column(name = "photo")
    private String photo;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idcategory")
    private Category category;

    @OneToMany(mappedBy = "article")
    private List<LigneVente> ligneVentes;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeClient> ligneCommandeClients;

    @OneToMany(mappedBy = "article")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

    @OneToMany(mappedBy = "articles")
    private List<MouvementDeStock> mouvementDeStocks;


}

