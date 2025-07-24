package com.salah.gestiondestock.Web.Api;

import static com.salah.gestiondestock.Utils.Constants.APP_ROOT;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.salah.gestiondestock.Dtos.MouvementDeStockDto;

import io.swagger.v3.oas.annotations.tags.Tag;

@Tag(name = "mouvementdestock")
public interface MouvementDeStockApi {
  @GetMapping(APP_ROOT + "/mvtstk/stockreel/{idArticle}")
  BigDecimal stockReelArticle(@PathVariable("idArticle") Integer idArticle);

  @GetMapping(APP_ROOT + "/mvtstk/filter/article/{idArticle}")
  List<MouvementDeStockDto> mvtStkArticle(@PathVariable("idArticle") Integer idArticle);

  @PostMapping(APP_ROOT + "/mvtstk/entree")
  MouvementDeStockDto entreeStock(@RequestBody MouvementDeStockDto dto);

  @PostMapping(APP_ROOT + "/mvtstk/sortie")
  MouvementDeStockDto sortieStock(@RequestBody MouvementDeStockDto dto);

  @PostMapping(APP_ROOT + "/mvtstk/correctionpos")
  MouvementDeStockDto correctionStockPos(@RequestBody MouvementDeStockDto dto);

  @PostMapping(APP_ROOT + "/mvtstk/correctionneg")
  MouvementDeStockDto correctionStockNeg(@RequestBody MouvementDeStockDto dto);

}
