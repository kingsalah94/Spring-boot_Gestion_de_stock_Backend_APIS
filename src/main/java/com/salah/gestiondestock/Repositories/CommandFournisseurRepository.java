package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.Dtos.CommandFournisseurDto;
import com.salah.gestiondestock.model.CommandFournisseur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommandFournisseurRepository extends JpaRepository<CommandFournisseur,Integer> {
    Optional<CommandFournisseur> findByCode(String code);
}
