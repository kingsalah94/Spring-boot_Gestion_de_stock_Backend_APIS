package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.ArticlesMapper;
import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.ArticlesRepository;
import com.salah.gestiondestock.Services.ArticlesService;
import com.salah.gestiondestock.Validators.ArticleValidator;
import com.salah.gestiondestock.model.Articles;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.stream.Collectors;

import static com.salah.gestiondestock.DtoMappers.ArticlesMapper.*;

@Service
@Slf4j
public class ArticlesServiceImpl implements ArticlesService {

    private final View error;
    private final ArticlesRepository articlesRepository;
    private final ArticlesMapper articlesMapper;
    @Autowired
    public ArticlesServiceImpl(ArticlesRepository articlesRepository,
                               ArticlesMapper articlesMapper,
                               View error) {
        this.articlesRepository = articlesRepository;
        this.articlesMapper = articlesMapper;
        this.error = error;
    }


    @Override
    public ArticlesDto save(ArticlesDto dto) {
        Articles entity = articlesMapper.toEntity(dto);
        Articles saved = articlesRepository.save(entity);
        return articlesMapper.toDto(saved);
    }

    @Override
    public ArticlesDto findById(Integer id) {
        return articlesRepository.findById(id)
                .map(articlesMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Article non trouvé avec ID : " + id));
    }

    @Override
    public List<ArticlesDto> findAll() {
        return articlesRepository.findAll()
                .stream()
                .map(articlesMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        articlesRepository.deleteById(id);
    }


//    @Override
//    public ArticlesDto addArticles(ArticlesDto articlesDto) {
//        List<String> errors = ArticleValidator.validate(articlesDto);
//        if (!errors.isEmpty()) {
//            //Logger l'erreur
//            log.error("Error while adding articles, Article is not valid {}",articlesDto);
//            //Lever l'exception
//            throw new InvalideEntityException("L'article n'est pas valide", ErrorCodes.ARTICLE_NOT_VALIDE, errors);
//        }
//        Articles articles = dtoMapper.fromArticlesDTO(articlesDto);
//        Articles addedArticles = articlesRepository.save(articles);
//        return dtoMapper.fromArticles(addedArticles);
//    }
//
//    @Override
//    public ArticlesDto updateArticles(ArticlesDto articlesDto) {
//        List<String> errors = ArticleValidator.validate(articlesDto);
//        if (!errors.isEmpty()) {
//            log.error("Error while updating articles, Article is not valid {}",articlesDto);
//            throw new InvalideEntityException("Larticles n'est pas valide", ErrorCodes.ARTICLE_NOT_VALIDE, errors);
//        }
//        Articles articles = dtoMapper.fromArticlesDTO(articlesDto);
//        Articles updatedArticles = articlesRepository.save(articles);
//        return dtoMapper.fromArticles(updatedArticles);
//    }
//
//
//    @Override
//    public ArticlesDto getOneArticles(Integer id) throws EntityNotFoundException {
//        if (id == null) {
//            log.error("Articles ID is null ");
//            return null;
//        }
//        Articles articles = articlesRepository.findById(id)
//                .orElseThrow(()->new EntityNotFoundException("Articles not found",ErrorCodes.ARTICLE_NOT_FOUND));
//        return dtoMapper.fromArticles(articles);
//    }
//
//    @Override
//    public ArticlesDto getArticleByCodeArticle(String codeArticle) throws EntityNotFoundException {
//        if (!StringUtils.hasLength(codeArticle)){
//            log.error("Article code is null ");
//            return null;
//        }
//        Articles articles = articlesRepository.findArticlesByCodeArticle(codeArticle)
//                .orElseThrow(()->new EntityNotFoundException("Articles not found",ErrorCodes.ARTICLE_NOT_FOUND));
//        return dtoMapper.fromArticles(articles);
//    }
//
//    @Override
//    public List<ArticlesDto> getAllArticles() {
//        List<Articles> articles = articlesRepository.findAll();
//        return articles.stream()
//                .map(articles1 -> dtoMapper.fromArticles(articles1))
//                .collect(Collectors.toList());
//    }





//    @Override
//    public void deleteArticles(Integer id) {
//        if (id == null) {
//            log.error("Articles ID is null {}",error);
//            return;
//        }
//        articlesRepository.deleteById(id);
//    }



}
