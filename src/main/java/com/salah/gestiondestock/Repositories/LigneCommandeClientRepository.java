package com.salah.gestiondestock.Repositories;

import java.util.List;

import com.salah.gestiondestock.model.LigneCommandeClient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {

    //List<LigneCommandeClient> findAllByCommandClient(Integer id);

    //List<LigneCommandeClient> findAllByArticle(Integer id);

    @Query("SELECT l FROM LigneCommandeClient l WHERE l.commandClient.id = :id")
    List<LigneCommandeClient> findAllByCommandeClientId(@Param("id") Integer id);

    @Query("SELECT l FROM LigneCommandeClient l WHERE l.articles.id = :id")
    List<LigneCommandeClient> findAllByArticleId(@Param("id") Integer id);
}
