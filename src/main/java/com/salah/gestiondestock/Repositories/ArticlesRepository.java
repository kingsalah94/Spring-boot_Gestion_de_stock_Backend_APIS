package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.List;


public interface ArticlesRepository extends JpaRepository<Articles,Integer> {

    Optional <Articles> findArticlesByCodeArticle(String codeArticle) throws EntityNotFoundException;
    
    List<Articles> findAllByCategory(Integer idCategory);
}
