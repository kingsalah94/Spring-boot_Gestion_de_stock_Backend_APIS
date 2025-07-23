package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

import com.salah.gestiondestock.model.Utilisateur;

@Data
@Builder
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


    public static UtilisateurDto fromEntity(Utilisateur utilisateur) {
    if (utilisateur == null) {
      return null;
    }

    return UtilisateurDto.builder()
        .id(utilisateur.getId())
        .nom(utilisateur.getNom())
        .prenom(utilisateur.getPrenom())
        .email(utilisateur.getEmail())
        .motDePasse(utilisateur.getMoteDePasse())
        .dateDeNaissance(utilisateur.getDateDeNaissance())
        .adresseDto(AdresseDto.fromEntity(utilisateur.getAdresse()))
        .photo(utilisateur.getPhoto())
        .entrepriseDto(EntrepriseDto.fromEntity(utilisateur.getEntreprise()))
        .rolesDtos(
            utilisateur.getRoles() != null ?
                utilisateur.getRoles().stream()
                    .map(RolesDto::fromEntity)
                    .collect(Collectors.toList()) : null
        )
        .build();
  }

  public static Utilisateur toEntity(UtilisateurDto dto) {
    if (dto == null) {
      return null;
    }

    Utilisateur utilisateur = new Utilisateur();
    utilisateur.setId(dto.getId());
    utilisateur.setNom(dto.getNom());
    utilisateur.setPrenom(dto.getPrenom());
    utilisateur.setEmail(dto.getEmail());
    utilisateur.setMoteDePasse(dto.getMotDePasse());
    utilisateur.setDateDeNaissance(dto.getDateDeNaissance());
    utilisateur.setAdresse(AdresseDto.toEntity(dto.getAdresseDto()));
    utilisateur.setPhoto(dto.getPhoto());
    utilisateur.setEntreprise(EntrepriseDto.toEntity(dto.getEntrepriseDto()));

    return utilisateur;
  }
}
