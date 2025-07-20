package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.VentesDto;
import com.salah.gestiondestock.model.Ventes;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {LigneVenteMapper.class})
public interface VentesMapper {
    VentesDto toDto(Ventes entity);
    Ventes toEntity(VentesDto dto);
}
