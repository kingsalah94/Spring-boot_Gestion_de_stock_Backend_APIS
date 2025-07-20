package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.LigneCommandeFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LingeCommandeFournisseurRepository extends JpaRepository<LigneCommandeFournisseur,Integer> {
}
