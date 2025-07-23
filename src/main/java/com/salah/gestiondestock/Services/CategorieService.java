package com.salah.gestiondestock.Services;

import com.salah.gestiondestock.Dtos.CategoryDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;

import java.util.List;

public interface CategorieService {
    
    CategoryDto save(CategoryDto dto);

    CategoryDto findById(Integer id);

    CategoryDto findByCode(String code);

    List<CategoryDto> findAll();

    void delete(Integer id);
}
