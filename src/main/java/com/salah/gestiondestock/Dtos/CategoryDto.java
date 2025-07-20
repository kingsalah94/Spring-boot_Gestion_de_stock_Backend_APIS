package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class CategoryDto {
    //private Integer id;
    private String code;
    private String designation;
    private List<ArticlesDto> articlesDtos;
}
