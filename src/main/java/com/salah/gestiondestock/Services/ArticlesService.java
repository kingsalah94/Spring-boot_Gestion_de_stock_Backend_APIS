package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import java.util.List;

public interface ArticlesService {
    /**
     * Saves a new article.
     *
     * @param dto the article data transfer object to save
     * @return the saved article data transfer object
     */

    ArticlesDto save(ArticlesDto dto);
    ArticlesDto update(Long id, ArticlesDto dto);
    ArticlesDto findById(Integer id);
    List<ArticlesDto> findAll();
    void delete(Integer id);

}
