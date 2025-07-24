package com.salah.gestiondestock.Repositories;

import java.util.List;

import com.salah.gestiondestock.model.LigneVente;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneVentesRepository extends JpaRepository<LigneVente,Integer> {

     @Query("SELECT l FROM LigneVente l WHERE l.article.id = :idArticle")
    List<LigneVente> findAllByArticleId(@Param("idArticle") Integer idArticle);

    @Query("SELECT l FROM LigneVente l WHERE l.vente.id = :idVente")
    List<LigneVente> findAllByVenteId(@Param("idVente") Integer idVente);
}
