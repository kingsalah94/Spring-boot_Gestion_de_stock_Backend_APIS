package com.salah.gestiondestock.model;

import com.salah.gestiondestock.Enums.EtatCommande;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "CommandFournisseurs")
public class CommandFournisseur extends AbstractEntity{

    @Column(name = "code")
    private String code;

    @Column(name = "datecommande")
    private Instant dateCommande;

    @Column(name = "etatcommande")
    @Enumerated(EnumType.STRING)
    private EtatCommande etatCommande;

    @Column(name = "identreprise")
    private Integer idEntreprise;

    @ManyToOne
    @JoinColumn(name = "idfournisseur")
    private Fournisseur fournisseur;

    @OneToMany(mappedBy = "commandFournisseur")
    private List<LigneCommandeFournisseur> ligneCommandeFournisseurs;

}
