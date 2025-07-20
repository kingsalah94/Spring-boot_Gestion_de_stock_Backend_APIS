package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.CategoryDto;
import com.salah.gestiondestock.model.Category;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
   CategoryMapper INSTANCE = Mappers.getMapper(CategoryMapper.class);
    CategoryDto toDto(Category entity);
    Category toEntity(CategoryDto dto);

//    public CategoryDto fromCategory(Category category){
//        CategoryDto categoryDto = new CategoryDto();
//        BeanUtils.copyProperties(category,categoryDto);
//        return categoryDto;
//    }
//
//    public Category fromCategoryDto(CategoryDto categoryDto){
//        Category category = new Category();
//        BeanUtils.copyProperties(categoryDto,category);
//        return category;
//    }
}
