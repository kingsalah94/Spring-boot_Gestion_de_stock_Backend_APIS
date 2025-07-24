package com.salah.gestiondestock.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.salah.gestiondestock.Dtos.VentesDto;
import com.salah.gestiondestock.Services.VenteService;
import com.salah.gestiondestock.Web.Api.VentesApi;

import lombok.AllArgsConstructor;

@RestController

public class VentesController implements VentesApi{

    private VenteService ventesService;

  @Autowired
  public VentesController(VenteService ventesService) {
    this.ventesService = ventesService;
  }

  @Override
  public VentesDto save(VentesDto dto) {
    return ventesService.save(dto);
  }

  @Override
  public VentesDto findById(Integer id) {
    return ventesService.findById(id);
  }

  @Override
  public VentesDto findByCode(String code) {
    return ventesService.findByCode(code);
  }

  @Override
  public List<VentesDto> findAll() {
    return ventesService.findAll();
  }

  @Override
  public void delete(Integer id) {
    ventesService.delete(id);
  }
}
