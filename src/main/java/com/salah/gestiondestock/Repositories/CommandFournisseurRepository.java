package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.Dtos.CommandFournisseurDto;
import com.salah.gestiondestock.model.CommandFournisseur;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

import com.salah.gestiondestock.model.CommandClient;

public interface CommandFournisseurRepository extends JpaRepository<CommandFournisseur,Integer> {
    Optional<CommandFournisseur> findCommandFournisseurByCode(String code);
    List<CommandClient> findAllByFournisseur(Integer idFournisseur);

}
