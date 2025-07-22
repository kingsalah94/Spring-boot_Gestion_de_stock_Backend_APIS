package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class FournisseurDto {

    private Integer id;
    private String nom;

    private String prenom;

    private String email;

    private String photo;

    private String numTel;

    private AdresseDto adresseDto;

    private Integer idEntreprise;

    
    @JsonIgnore
    private List<CommandFournisseurDto> commandFournisseurDtos;
}