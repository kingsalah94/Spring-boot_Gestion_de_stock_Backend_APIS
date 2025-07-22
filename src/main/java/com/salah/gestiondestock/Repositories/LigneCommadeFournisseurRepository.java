package com.salah.gestiondestock.Repositories;

import java.util.List;

import com.salah.gestiondestock.model.Fournisseur;
import com.salah.gestiondestock.model.LigneCommandeFournisseur;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommadeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer> {
    List<LigneCommandeFournisseur> findAllByCommandeFournisseurs(Integer idFournisseur);

    List<LigneCommandeFournisseur> findAllByArticle(Integer idArticle);
}
