package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.CommandFournisseur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

import com.salah.gestiondestock.model.CommandClient;

public interface CommandFournisseurRepository extends JpaRepository<CommandFournisseur,Integer> {
    Optional<CommandFournisseur> findCommandFournisseurByCode(String code);
    
    @Query("SELECT cf FROM CommandFournisseur cf WHERE cf.fournisseur.id = :idFournisseur")
    List<CommandClient> findAllByFournisseurId(@Param("idFournisseur") Integer idFournisseur);


}
