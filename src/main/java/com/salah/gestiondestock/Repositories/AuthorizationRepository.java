package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.Authorization;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorizationRepository extends JpaRepository<Authorization,Integer> {

}
