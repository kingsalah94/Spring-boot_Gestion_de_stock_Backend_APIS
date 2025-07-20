package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.LigneCommandeFournisseurDto;

import java.util.List;

public interface LigneCommandeFournisseurService {

    LigneCommandeFournisseurDto findById(Integer id);

    List<LigneCommandeFournisseurDto> findAll();

    void delete(Integer id);
}

