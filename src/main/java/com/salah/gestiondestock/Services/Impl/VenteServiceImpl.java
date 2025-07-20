/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.salah.gestiondestock.Services.Impl;

import java.util.List;

import com.salah.gestiondestock.DtoMappers.VentesMapper;
import com.salah.gestiondestock.Dtos.VentesDto;
import com.salah.gestiondestock.Repositories.VentesRepository;
import com.salah.gestiondestock.Services.VenteService;

/**
 *
 * @author bahac
 */
public class VenteServiceImpl implements VenteService{

    
    private final VentesRepository ventesRepository;
    private final VentesMapper ventesMapper;
   
   
    public VenteServiceImpl(com.salah.gestiondestock.DtoMappers.VentesMapper ventesMapper) {
        this.ventesRepository = null;
        this.ventesMapper = ventesMapper;
    }

    @Override
    public VentesDto save(VentesDto dto) {
        if (dto == null) {
            throw new IllegalArgumentException("VentesDto cannot be null");
        }
        // Convert DTO to entity, save, then convert back to DTO
        var ventesEntity = ventesMapper.toEntity(dto);
        var savedEntity = ventesRepository.save(ventesEntity);
        return ventesMapper.toDto(savedEntity);
    }

    @Override
    public VentesDto findById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        return ventesRepository.findById(id)
                .map(ventesMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Vente not found with id: " + id));
    }

    @Override
    public VentesDto update(Integer id, VentesDto dto) {
        if (id == null || dto == null) {
            throw new IllegalArgumentException("ID and VentesDto cannot be null");
        }
        var existingVente = ventesRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Vente not found with id: " + id));
        var updatedVente = ventesMapper.toEntity(dto);
        updatedVente.setId(existingVente.getId()); // Ensure AbstractEntity provides getId() method
        var savedEntity = ventesRepository.save(updatedVente);
        return ventesMapper.toDto(savedEntity);
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        if (!ventesRepository.existsById(id)) {
            throw new IllegalArgumentException("Vente not found with id: " + id);
        }
        ventesRepository.deleteById(id);
    }

    @Override
    public VentesDto findByCode(String code) {
        if (code == null || code.isEmpty()) {
            throw new IllegalArgumentException("Code cannot be null or empty");
        }
        return ventesRepository.findByCode(code)
                .map(ventesMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("Vente not found with code: " + code));
    }

    // @Override
    // public VentesDto findByIdWithArticle(Integer id) {
    //     if (id == null) {
    //         throw new IllegalArgumentException("ID cannot be null");
    //     }
    //     var venteEntity = ventesRepository.findByIdWithArticles(id)
    //             .orElseThrow(() -> new IllegalArgumentException("Vente not found with id: " + id));
    //     return ventesMapper.toDtoWithArticles(venteEntity);
    // }

    @Override
    public List<VentesDto> findAll() {
        return ventesRepository.findAll()
                .stream()
                .map(ventesMapper::toDto)
                .toList();
    }

    // @Override
    // public List<VentesDto> findAllWithArticle() {
    //     return ventesRepository.findAllWithArticles()
    //             .stream()
    //             .map(ventesMapper::toDtoWithArticles)
    //             .toList();
    // }

}
