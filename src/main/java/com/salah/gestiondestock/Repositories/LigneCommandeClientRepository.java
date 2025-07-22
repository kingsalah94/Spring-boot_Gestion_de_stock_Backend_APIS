package com.salah.gestiondestock.Repositories;

import java.util.List;

import com.salah.gestiondestock.model.LigneCommandeClient;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneCommandeClientRepository extends JpaRepository<LigneCommandeClient,Integer> {

    List<LigneCommandeClient> findAllByCommandClient(Integer id);

    List<LigneCommandeClient> findAllByArticle(Integer id);
}
