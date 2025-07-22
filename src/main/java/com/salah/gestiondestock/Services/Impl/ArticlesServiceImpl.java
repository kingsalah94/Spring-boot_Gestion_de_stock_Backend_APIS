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


    @Override
    public ArticlesDto update(Long id, ArticlesDto dto) {
        Articles existingArticle = articlesRepository.findById(id.intValue())
                .orElseThrow(() -> new EntityNotFoundException("Article non trouvé avec ID : " + id));
        // Update fields from dto
        existingArticle.setCodeArticle(dto.getCodeArticle());
        existingArticle.setDesignation(dto.getDesignation());
        existingArticle.setPrixUnitaireHt(dto.getPrixUnitaireHt());
        existingArticle.setPrixUnitaireTtc(dto.getPrixUnitaireTtc());
        existingArticle.setTauxTva(dto.getTauxTva());
        existingArticle.setCategory(dto.getCategory() != null ? articlesMapper.toEntity(dto.getCategory()) : null);
        Articles updatedArticle = articlesRepository.save(existingArticle);
        return articlesMapper.toDto(updatedArticle);
    }


}
