package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.FournisseurMapper;
import com.salah.gestiondestock.Dtos.FournisseurDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Repositories.FournisseurRepository;
import com.salah.gestiondestock.Services.FournisseurService;
import com.salah.gestiondestock.model.Fournisseur;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class FournisseurServiceImpl implements FournisseurService {
    private final FournisseurRepository fournisseurRepository;
    private final FournisseurMapper fournisseurMapper;

    public FournisseurServiceImpl(FournisseurRepository fournisseurRepository, FournisseurMapper fournisseurMapper) {
        this.fournisseurRepository = fournisseurRepository;
        this.fournisseurMapper = fournisseurMapper;
    }

    @Override
    public FournisseurDto save(FournisseurDto dto) {
        Fournisseur fournisseur = fournisseurMapper.toEntity(dto);
        return fournisseurMapper.toDto(fournisseurRepository.save(fournisseur));
    }

    @Override
    public FournisseurDto findById(Integer id) {
        Optional<Fournisseur> fournisseur = fournisseurRepository.findById(id);
        return fournisseur
                .map(fournisseurMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Aucun fournisseur trouvé avec l'ID " + id));
    }

    @Override
    public List<FournisseurDto> findAll() {
        return fournisseurRepository.findAll()
                .stream()
                .map(fournisseurMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        fournisseurRepository.deleteById(id);
    }
}
