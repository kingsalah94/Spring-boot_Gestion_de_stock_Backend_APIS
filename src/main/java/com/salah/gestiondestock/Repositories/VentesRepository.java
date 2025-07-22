package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.Ventes;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.salah.gestiondestock.Dtos.VentesDto;

public interface VentesRepository extends JpaRepository<Ventes,Integer> {

    Optional<Ventes> findVentesByCode(String code);
}
