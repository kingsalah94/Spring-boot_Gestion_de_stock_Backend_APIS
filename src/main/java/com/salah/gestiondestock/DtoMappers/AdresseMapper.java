package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.AdresseDto;
import com.salah.gestiondestock.model.Adresse;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AdresseMapper {
    AdresseDto toDto(Adresse adresse);
    Adresse toEntity(AdresseDto adresseDto);
}
