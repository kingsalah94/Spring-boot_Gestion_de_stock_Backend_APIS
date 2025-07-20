package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
public class LigneCommandeFournisseurDto {

    private Integer id;
    private ArticlesDto articlesDto;

    private CommandFournisseurDto commandFournisseurDto;
}
