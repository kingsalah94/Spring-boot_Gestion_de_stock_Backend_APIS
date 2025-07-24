package com.salah.gestiondestock.Web.Controllers;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeFournisseurDto;
import com.salah.gestiondestock.Dtos.LigneVenteDto;
import com.salah.gestiondestock.Services.ArticlesService;
import com.salah.gestiondestock.Web.Api.ArticlesApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ArticleController implements ArticlesApi {

    private ArticlesService articlesService;

     @Autowired
  public ArticleController(
      ArticlesService articleService
  ) {
    this.articlesService = articleService;
  }

    @Override
  public ArticlesDto save(ArticlesDto dto) {
    return articlesService.save(dto);
  }
  @Override
  public ArticlesDto findById(Integer id) {
    return articlesService.findById(id);
  }

  @Override
  public ArticlesDto findByCodeArticle(String codeArticle) {
    return articlesService.findByCodeArticle(codeArticle);
  }

  @Override
  public List<ArticlesDto> findAll() {
    return articlesService.findAll();
  }

  @Override
  public List<LigneVenteDto> findHistoriqueVentes(Integer idArticle) {
    return articlesService.findHistoriqueVentes(idArticle);
  }

  @Override
  public List<LigneCommandeClientDto> findHistoriaueCommandeClient(Integer idArticle) {
    return articlesService.findHistoriqueCommandeClient(idArticle);
  }

  @Override
  public List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle) {
    return articlesService.findHistoriqueCommandeFournisseur(idArticle);
  }

  @Override
  public List<ArticlesDto> findAllArticleByIdCategory(Integer idCategory) {
    return articlesService.findAllArticleByIdCategory(idCategory);
  }

  @Override
  public void delete(Integer id) {
    articlesService.delete(id);
  }
}
