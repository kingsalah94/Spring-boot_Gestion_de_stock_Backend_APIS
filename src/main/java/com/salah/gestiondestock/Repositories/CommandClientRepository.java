package com.salah.gestiondestock.Repositories;

import java.util.Optional;

import com.salah.gestiondestock.model.CommandClient;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;


public interface CommandClientRepository extends JpaRepository<CommandClient,Integer> {

    Optional<CommandClient> findCommandClientByCode(String code);
    List<CommandClient> findAllByClient(Integer idClient);
}
