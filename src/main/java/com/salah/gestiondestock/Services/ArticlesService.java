package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;

import java.util.List;

public interface ArticlesService {
//    ArticlesDto addArticles(ArticlesDto articlesDto);
//
//    ArticlesDto updateArticles(ArticlesDto articlesDto);
//
//    void deleteArticles(Integer id);
//
//    ArticlesDto getOneArticles(Integer id) throws EntityNotFoundException;
//
//    ArticlesDto getArticleByCodeArticle(String codeArticle) throws EntityNotFoundException;
//
//    List<ArticlesDto> getAllArticles();

    ArticlesDto save(ArticlesDto dto);
    ArticlesDto update(Long id, ArticlesDto dto);
    ArticlesDto findById(Integer id);
    List<ArticlesDto> findAll();
    void delete(Integer id);

}
