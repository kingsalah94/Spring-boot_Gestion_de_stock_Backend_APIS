package com.salah.gestiondestock.Repositories;

import java.util.Optional;

import com.salah.gestiondestock.model.CommandClient;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CommandClientRepository extends JpaRepository<CommandClient, Integer> {

    Optional<CommandClient> findCommandClientByCode(String code);
    //List<CommandClient> findAllByClient(Integer idClient);

    @Query("SELECT c FROM CommandClient c WHERE c.client.id = :clientId")
    List<CommandClient> findAllByClientId(@Param("clientId") Integer clientId);

    //List<CommandeClient> findAllByFournisseur(Integer id);
}
