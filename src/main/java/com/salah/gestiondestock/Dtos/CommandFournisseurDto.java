package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class CommandFournisseurDto {

    private Integer id;
    private String code;

    private Instant dateCommande;

    private FournisseurDto fournisseurDto;

    private List<LigneCommandeFournisseurDto> ligneCommandeFournisseurDtos;
}
