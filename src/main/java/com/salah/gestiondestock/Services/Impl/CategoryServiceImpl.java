package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.CategoryMapper;
import com.salah.gestiondestock.Dtos.CategoryDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.CategoryRepository;
import com.salah.gestiondestock.Services.CategorieService;
import com.salah.gestiondestock.Validators.CategoryValidator;
import com.salah.gestiondestock.model.Category;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.stream.Collectors;

import static com.salah.gestiondestock.DtoMappers.CategoryMapper.*;

@Service
@Slf4j
@AllArgsConstructor
public class CategoryServiceImpl implements CategorieService {

    private final View error;
    private CategoryRepository categoryRepository;
    private CategoryMapper categoryMapper;

    public CategoryServiceImpl(CategoryRepository categoryRepository, CategoryMapper categoryMapper,View view) {
        this.categoryRepository = categoryRepository;
        this.categoryMapper = categoryMapper;
        this.error = view;
    }

    @org.springframework.beans.factory.annotation.Autowired
    public CategoryServiceImpl(View error) {
        this.error = error;
    }



    @Override
    public CategoryDto save(CategoryDto dto) {
        var errors = CategoryValidator.validate(dto);
        if (!errors.isEmpty()) {
            log.error("Categorie non valide: {}", dto);
            throw new InvalideEntityException("Categorie non valide", ErrorCodes.CATEGORY_NOT_VALIDE, errors);
        }
        Category entity = categoryMapper.INSTANCE.toEntity(dto);
        return CategoryMapper.INSTANCE.toDto(categoryRepository.save(entity));
    }

    @Override
    public CategoryDto findById(Integer id) {
        if (id == null) {
            log.error("ID Categorie est null");
            return null;
        }
        return categoryRepository.findById(id)
                .map(CategoryMapper.INSTANCE::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Aucune catégorie avec l'ID = " + id, ErrorCodes.CATEGORY_NOT_FOUND));
    }

//    @Override
//    public CategoryDto findByCode(String code) {
//        if (!StringUtils.hasLength(code)) {
//            log.error("Code categorie est null");
//            return null;
//        }
//        return categoryRepository.findByCode(code)
//                .map(CategoryMapper.INSTANCE::toDto)
//                .orElseThrow(() -> new EntityNotFoundException("Aucune catégorie avec le code = " + code, ErrorCodes.CATEGORY_NOT_FOUND));
//    }

    @Override
    public List<CategoryDto> findAll() {
        return categoryRepository.findAll()
                .stream()
                .map(CategoryMapper.INSTANCE::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public void delete(Integer id) {
        if (id == null) {
            log.error("ID categorie est null");
            return;
        }
        categoryRepository.deleteById(id);
    }
   
}
