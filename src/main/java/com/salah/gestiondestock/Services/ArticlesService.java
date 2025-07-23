package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.ArticlesDto;

import java.util.List;

import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeFournisseurDto;
import com.salah.gestiondestock.Dtos.LigneVenteDto;

public interface ArticlesService {
    /**
     * Saves a new article.
     *
     * @param dto the article data transfer object to save
     * @return the saved article data transfer object
     */

    ArticlesDto save(ArticlesDto dto);

    ArticlesDto findById(Integer id);

    ArticlesDto findByCodeArticle(String codeArticle);

    List<ArticlesDto> findAll();

    List<LigneVenteDto> findHistoriqueVentes(Integer idArticle);

    List<LigneCommandeClientDto> findHistoriqueCommandeClient(Integer idArticle);

    List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(Integer idArticle);

    List<ArticlesDto> findAllArticleByIdCategory(Integer idCategory);

    void delete(Integer id);


}
