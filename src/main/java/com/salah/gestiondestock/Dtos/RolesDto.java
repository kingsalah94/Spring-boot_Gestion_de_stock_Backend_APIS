package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
public class RolesDto {

    private Integer id;
    private String roleName;

    @JsonIgnore
    private UtilisateurDto utilisateurDto;

    private List<AuthorizationDto> authorizationDtos;
}
