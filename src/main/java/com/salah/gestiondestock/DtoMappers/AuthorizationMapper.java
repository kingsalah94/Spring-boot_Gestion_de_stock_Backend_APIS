package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.AuthorizationDto;
import com.salah.gestiondestock.model.Authorization;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {RolesMapper.class})
public interface AuthorizationMapper {
    AuthorizationDto toDto(Authorization entity);
    Authorization toEntity(AuthorizationDto dto);
}

