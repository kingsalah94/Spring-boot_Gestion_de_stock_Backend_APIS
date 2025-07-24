package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.time.Instant;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.salah.gestiondestock.model.Roles;

@Data
@Builder
public class RolesDto {

    private Integer id;
    private String roleName;
    private Instant creationDate;

    @JsonIgnore
    private UtilisateurDto utilisateurDto;

    private List<AuthorizationDto> authorizationDtos;

    public static RolesDto fromEntity(Roles roles) {
    if (roles == null) {
      return null;
    }
    return RolesDto.builder()
        .id(roles.getId())
        .roleName(roles.getRoleName())
        .creationDate(Instant.now())
        .build();
  }

  public static Roles toEntity(RolesDto dto) {
    if (dto == null) {
      return null;
    }
    Roles roles = new Roles();
    roles.setId(dto.getId());
    roles.setRoleName(dto.getRoleName());
    roles.setCreationDate(Instant.now());
    roles.setUtilisateur(UtilisateurDto.toEntity(dto.getUtilisateurDto()));
    return roles;
  }
}
