package com.salah.gestiondestock.Web.Controllers;

import com.salah.gestiondestock.Dtos.EntrepriseDto;
import com.salah.gestiondestock.Services.EntrepriseService;
import com.salah.gestiondestock.Web.Api.EntrepriseApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController

public class EntrepriseController implements EntrepriseApi {

    private EntrepriseService entrepriseService;

     @Autowired
  public EntrepriseController(EntrepriseService entrepriseService) {
    this.entrepriseService = entrepriseService;
  }

    @Override
    public EntrepriseDto save(EntrepriseDto dto) {
        return entrepriseService.save(dto);
    }

    @Override
    public EntrepriseDto findById(Integer id) {
        return entrepriseService.findById(id);
    }

    @Override
    public List<EntrepriseDto> findAll() {
        return entrepriseService.findAll();
    }

    @Override
    public void delete(Integer id) {
        entrepriseService.delete(id);
    }

}
