package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

@Data
public class UtilisateurDto {
    private Integer id;
    private String nom;
    private String prenom;
    private String motDePasse;
    private String email;
    private Instant dateDeNaissance;
    private AdresseDto adresseDto;
    private String photo;
    private EntrepriseDto entrepriseDto;
    private List<RolesDto> rolesDtos;
}
