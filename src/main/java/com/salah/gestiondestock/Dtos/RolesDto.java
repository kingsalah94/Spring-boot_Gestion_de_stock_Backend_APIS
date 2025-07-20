package com.salah.gestiondestock.Dtos;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
public class RolesDto {

    private Integer id;
    private String roleName;

    private UtilisateurDto utilisateurDto;

    private List<AuthorizationDto> authorizationDtos;
}
