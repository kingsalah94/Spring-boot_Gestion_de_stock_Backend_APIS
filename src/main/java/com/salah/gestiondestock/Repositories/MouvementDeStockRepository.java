package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.MouvementDeStock;

import java.math.BigDecimal;
import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MouvementDeStockRepository extends JpaRepository<MouvementDeStock,Integer> {

    @Query("SELECT SUM(m.quantite) FROM MouvementDeStock m WHERE m.articles.id = :idArticle")
    BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

    @Query("SELECT m FROM MouvementDeStock m WHERE m.articles.id = :idArticle")
    List<MouvementDeStock> findAllByArticleId(@Param("idArticle") Integer idArticle);

}
