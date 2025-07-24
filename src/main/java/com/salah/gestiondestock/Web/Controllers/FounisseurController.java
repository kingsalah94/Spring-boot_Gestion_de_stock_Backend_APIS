package com.salah.gestiondestock.Web.Controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.salah.gestiondestock.Dtos.FournisseurDto;
import com.salah.gestiondestock.Services.FournisseurService;
import com.salah.gestiondestock.Web.Api.FournisseurApi;



@RestController
public class FounisseurController implements FournisseurApi{


private FournisseurService fournisseurService;

 @Autowired
  public FounisseurController(FournisseurService fournisseurService) {
    this.fournisseurService = fournisseurService;
  }


  @Override
  public FournisseurDto save(FournisseurDto dto) {
    return fournisseurService.save(dto);
  }

  @Override
  public FournisseurDto findById(Integer id) {
    return fournisseurService.findById(id);
  }

  @Override
  public List<FournisseurDto> findAll() {
    return fournisseurService.findAll();
  }

  @Override
  public void delete(Integer id) {
    fournisseurService.delete(id);
  }
}
