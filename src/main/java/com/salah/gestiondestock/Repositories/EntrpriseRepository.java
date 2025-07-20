package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.Entreprise;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EntrpriseRepository extends JpaRepository<Entreprise,Integer> {

    Optional<Entreprise> findEntrepriseByNom(String name);
}
