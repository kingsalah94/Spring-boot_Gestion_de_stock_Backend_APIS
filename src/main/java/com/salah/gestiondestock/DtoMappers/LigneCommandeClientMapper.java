package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.model.LigneCommandeClient;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {ArticlesMapper.class, CommandClientMapper.class})
public interface LigneCommandeClientMapper {
    LigneCommandeClientDto toDto(LigneCommandeClient entity);
    LigneCommandeClient toEntity(LigneCommandeClientDto dto);

//    public LigneCommandeClientDto FromLigneCommandeClient(LigneCommandeClient ligneCommandeClient){
//        LigneCommandeClientDto ligneCommandeClientDto = new LigneCommandeClientDto();
//        BeanUtils.copyProperties(ligneCommandeClient,ligneCommandeClientDto);
//        return ligneCommandeClientDto;
//    }
//
//    public LigneCommandeClient FromLigneCommandeClientDto(LigneCommandeClientDto ligneCommandeClientDto){
//        LigneCommandeClient ligneCommandeClient = new LigneCommandeClient();
//        BeanUtils.copyProperties(ligneCommandeClientDto,ligneCommandeClient);
//        return ligneCommandeClient;
//    }
}
