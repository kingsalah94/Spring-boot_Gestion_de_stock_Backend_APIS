package com.salah.gestiondestock.Dtos;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salah.gestiondestock.model.Entreprise;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class EntrepriseDto {

    private Integer id;
    private String nom;

    private Instant creationDate;
    private Instant lastModifiedDate;

    private String description;

    private AdresseDto adresseDto;


    private String codeFiscal;


    private String photo;

    private String email;

    private String numTel;
    
    private String siteWeb;

    @JsonIgnore
    private List<UtilisateurDto> utilisateurs;

    public static EntrepriseDto fromEntity(Entreprise entreprise) {
    if (entreprise == null) {
      return null;
    }
    return EntrepriseDto.builder()
        .id(entreprise.getId())
        .nom(entreprise.getNom())
        .creationDate(Instant.now())
        .description(entreprise.getDescription())
        .adresseDto(AdresseDto.fromEntity(entreprise.getAdresse()))
        .codeFiscal(entreprise.getCodeFiscal())
        .photo(entreprise.getPhoto())
        .email(entreprise.getEmail())
        .numTel(entreprise.getNumTel())
        .siteWeb(entreprise.getSteWeb())
        .build();
  }

  public static Entreprise toEntity(EntrepriseDto dto) {
    if (dto == null) {
      return null;
    }
    Entreprise entreprise = new Entreprise();
    entreprise.setId(dto.getId());
    entreprise.setNom(dto.getNom());
    entreprise.setCreationDate(Instant.now());
    entreprise.setDescription(dto.getDescription());
    entreprise.setAdresse(AdresseDto.toEntity(dto.getAdresseDto()));
    entreprise.setCodeFiscal(dto.getCodeFiscal());
    entreprise.setPhoto(dto.getPhoto());
    entreprise.setEmail(dto.getEmail());
    entreprise.setNumTel(dto.getNumTel());
    entreprise.setSteWeb(dto.getSiteWeb());

    return entreprise;
  }

}
