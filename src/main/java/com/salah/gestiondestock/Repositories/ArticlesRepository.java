package com.salah.gestiondestock.Repositories;

import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.model.Articles;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ArticlesRepository extends JpaRepository<Articles,Integer> {

    Optional <Articles> findArticlesByCodeArticle(String codeArticle) throws EntityNotFoundException;
}
