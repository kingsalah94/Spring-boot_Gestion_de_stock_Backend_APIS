package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.UtilisateurDto;
import com.salah.gestiondestock.model.Utilisateur;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {EntrepriseMapper.class, RolesMapper.class})
public interface UtilisateurMapper {

    UtilisateurMapper INSTANCE = Mappers.getMapper(UtilisateurMapper.class);
    
    UtilisateurDto toDto(Utilisateur entity);
    Utilisateur toEntity(UtilisateurDto dto);
}
