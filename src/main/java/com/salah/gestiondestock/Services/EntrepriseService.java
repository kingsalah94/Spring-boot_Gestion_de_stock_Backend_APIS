package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.EntrepriseDto;

import java.util.List;

public interface EntrepriseService {

  EntrepriseDto save(EntrepriseDto dto);

  EntrepriseDto findById(Integer id);

  List<EntrepriseDto> findAll();

  void delete(Integer id);

}
