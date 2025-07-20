/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */

package com.salah.gestiondestock.Services;

import java.util.List;

import com.salah.gestiondestock.Dtos.VentesDto;

/**
 *
 * @author bahac
 */
public interface VenteService {

    VentesDto save(VentesDto dto);
    VentesDto findById(Integer id);
    VentesDto update(Integer id, VentesDto dto);
    void delete(Integer id);
    VentesDto findByCode(String code);
    
   // VentesDto findByIdWithArticle(Integer id);
    List<VentesDto> findAll();
   // List<VentesDto> findAllWithArticle();

}
