package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

@Data
public class LigneCommandeClientDto {

    private Integer id;
    private ArticlesDto articlesDto;
    private CommandClientDto commandClientDto;
}
