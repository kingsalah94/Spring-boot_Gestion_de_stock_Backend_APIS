package com.salah.gestiondestock.Repositories;

import java.util.List;

import com.salah.gestiondestock.model.LigneVente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVentesRepository extends JpaRepository<LigneVente,Integer> {

    List<LigneVente> findAllByArticle(Integer idArticle);

    List<LigneVente> findAllByVente(Integer id);
}
