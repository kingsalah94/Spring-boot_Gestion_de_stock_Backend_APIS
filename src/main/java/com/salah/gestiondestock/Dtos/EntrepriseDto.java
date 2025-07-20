package com.salah.gestiondestock.Dtos;

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
}
