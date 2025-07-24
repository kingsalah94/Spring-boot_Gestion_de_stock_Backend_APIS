package com.salah.gestiondestock.Web.Controllers;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.salah.gestiondestock.Dtos.MouvementDeStockDto;
import com.salah.gestiondestock.Services.MouvementStockService;
import com.salah.gestiondestock.Web.Api.MouvementDeStockApi;

@RestController
public class MouvementDeStockController implements MouvementDeStockApi{
    
  private MouvementStockService service;

  
  @Autowired
  public MouvementDeStockController(MouvementStockService service) {
    this.service = service;
  }


  @Override
  public BigDecimal stockReelArticle(Integer idArticle) {
    return service.stockReelArticle(idArticle);
  }

  @Override
  public List<MouvementDeStockDto> mvtStkArticle(Integer idArticle) {
    return service.mvtStkArticle(idArticle);
  }

  @Override
  public MouvementDeStockDto entreeStock(MouvementDeStockDto dto) {
    return service.entreeStock(dto);
  }

  @Override
  public MouvementDeStockDto sortieStock(MouvementDeStockDto dto) {
    return service.sortieStock(dto);
  }

  @Override
  public MouvementDeStockDto correctionStockPos(MouvementDeStockDto dto) {
    return service.correctionStockPos(dto);
  }

  @Override
  public MouvementDeStockDto correctionStockNeg(MouvementDeStockDto dto) {
    return service.correctionStockNeg(dto);
  }
}
