package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.CommandClientDto;
import com.salah.gestiondestock.model.CommandClient;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {ClientMapper.class, LigneCommandeClientMapper.class})
public interface CommandClientMapper {
    CommandClientDto toDto(CommandClient entity);
    CommandClient toEntity(CommandClientDto dto);


//    public CommandClientDto fromCommandClient(CommandClient commandClient){
//        CommandClientDto commandClientDto  = new CommandClientDto();
//        BeanUtils.copyProperties(commandClient,commandClientDto);
//        return commandClientDto;
//    }
//
//    public CommandClient fromCommandClientDto(CommandClientDto commandClientDto){
//        CommandClient commandClient =new CommandClient();
//        BeanUtils.copyProperties(commandClientDto,commandClient);
//        return commandClient;
//    }
}
