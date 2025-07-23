package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.MouvementDeStock;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jdbc.repository.query.Query;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface MouvementDeStockRepository extends JpaRepository<MouvementDeStock,Integer> {

@Query("select sum(m.quantite) from mouvementDeStock m where m.articles.id = :idArticles")
BigDecimal stockReelArticle(@Param("idArticle") Integer idArticle);

List<MouvementDeStock> findAllByArticles(Integer idArticles);


}
