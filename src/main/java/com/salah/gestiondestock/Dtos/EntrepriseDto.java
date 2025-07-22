package com.salah.gestiondestock.Dtos;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Builder;
import lombok.Data;

@Data
public class EntrepriseDto {

    private Integer id;
    private String nom;

    private String description;

    private AdresseDto adresseDto;


    private String codeFiscal;


    private String photo;

    private String email;

    private String numTel;
    
    private String siteWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;
}
