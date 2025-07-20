package com.salah.gestiondestock.model;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "LigneCommandeClients")
public class LigneCommandeClient extends AbstractEntity{

    @ManyToOne
    @JoinColumn(name = "idarticle")
    private Articles article;

    @ManyToOne
    @JoinColumn(name = "idcommandeclient")
    private CommandClient commandClient;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prixunitaire")
    private BigDecimal prixUnitaire;

    @Column(name = "identreprise")
    private Integer idEntreprise;

}
