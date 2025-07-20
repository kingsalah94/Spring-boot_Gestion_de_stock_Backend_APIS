package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.model.MouvementDeStock;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MouvementDeStockRepository extends JpaRepository<MouvementDeStock,Integer> {
}
