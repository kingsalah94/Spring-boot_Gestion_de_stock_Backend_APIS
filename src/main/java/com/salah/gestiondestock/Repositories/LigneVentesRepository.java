package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.LigneVente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LigneVentesRepository extends JpaRepository<LigneVente,Integer> {
}
