package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.LigneVenteDto;
import com.salah.gestiondestock.model.LigneVente;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {VentesMapper.class, ArticlesMapper.class})
public interface LigneVenteMapper {
    LigneVenteDto toDto(LigneVente entity);
    LigneVente toEntity(LigneVenteDto dto);
}
