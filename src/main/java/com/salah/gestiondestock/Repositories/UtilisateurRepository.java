package com.salah.gestiondestock.Repositories;

import java.util.Optional;

import org.springframework.data.jdbc.repository.query.Query;

import com.salah.gestiondestock.model.Utilisateur;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

public interface UtilisateurRepository extends JpaRepository<Utilisateur,Integer> {


     @Query(value = "select u from Utilisateur u where u.email = :email")
     Optional<Utilisateur> findUtilisateurByEmail(@Param("email") String email);


}
