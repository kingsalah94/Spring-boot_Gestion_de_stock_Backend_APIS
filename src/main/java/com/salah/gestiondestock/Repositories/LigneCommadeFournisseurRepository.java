package com.salah.gestiondestock.Repositories;

import java.util.List;

import com.salah.gestiondestock.model.Fournisseur;
import com.salah.gestiondestock.model.LigneCommandeFournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneCommadeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur, Integer> {
   @Query("SELECT l FROM LigneCommandeFournisseur l WHERE l.commandFournisseur.id = :idCommandFournisseur")
    List<LigneCommandeFournisseur> findAllByCommandeFournisseurId(@Param("idCommandFournisseur") Integer idCommandFournisseur);

    @Query("SELECT l FROM LigneCommandeFournisseur l WHERE l.article.id = :idArticle")
    List<LigneCommandeFournisseur> findAllByArticleId(@Param("idArticle") Integer idArticle);
}
