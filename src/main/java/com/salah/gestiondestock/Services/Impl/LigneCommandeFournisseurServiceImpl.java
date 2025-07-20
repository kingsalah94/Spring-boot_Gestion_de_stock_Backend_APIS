package com.salah.gestiondestock.Services.Impl;


import com.salah.gestiondestock.DtoMappers.LigneCommandeFournisseurMapper;
import com.salah.gestiondestock.Dtos.LigneCommandeFournisseurDto;
import com.salah.gestiondestock.Repositories.LigneCommadeFournisseurRepository;
import com.salah.gestiondestock.Services.LigneCommandeFournisseurService;

import java.util.List;

public class LigneCommandeFournisseurServiceImpl implements LigneCommandeFournisseurService {

    private final LigneCommadeFournisseurRepository ligneCommadeFournisseurRepository;
    private final LigneCommandeFournisseurMapper ligneCommandeFournisseurMapper;

    public LigneCommandeFournisseurServiceImpl(LigneCommadeFournisseurRepository ligneCommadeFournisseurRepository, LigneCommandeFournisseurMapper ligneCommandeFournisseurMapper) {
        this.ligneCommadeFournisseurRepository = ligneCommadeFournisseurRepository;
        this.ligneCommandeFournisseurMapper = ligneCommandeFournisseurMapper;
    }

    @Override
    public LigneCommandeFournisseurDto findById(Integer id) {
        return null;
    }

    @Override
    public List<LigneCommandeFournisseurDto> findAll() {
        return List.of();
    }

    @Override
    public void delete(Integer id) {

    }
}
