package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.RolesDto;
import com.salah.gestiondestock.model.Roles;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
@Mapper(componentModel = "spring")
public interface RolesMapper {
    RolesDto toDto(Roles entity);
    Roles toEntity(RolesDto dto);
}
