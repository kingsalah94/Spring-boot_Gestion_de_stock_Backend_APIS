package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.ClientDto;
import com.salah.gestiondestock.model.Client;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {AdresseMapper.class, CommandClientMapper.class})
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    ClientDto toDto(Client entity);
    Client toEntity(ClientDto dto);
}
