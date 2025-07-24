package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.List;


public interface ArticlesRepository extends JpaRepository<Articles,Integer> {

    Optional <Articles> findArticlesByCodeArticle(String codeArticle) throws EntityNotFoundException;

    @Query("SELECT a FROM Articles a WHERE a.category.id = :idCategory")
    List<Articles> findAllByCategoryId(@Param("idCategory") Integer idCategory);
}