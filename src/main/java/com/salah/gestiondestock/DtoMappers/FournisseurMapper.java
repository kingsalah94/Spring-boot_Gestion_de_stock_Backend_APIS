package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.FournisseurDto;
import com.salah.gestiondestock.model.Fournisseur;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {AdresseMapper.class, CommandFournisseurMapper.class})
public interface FournisseurMapper {
    FournisseurDto toDto(Fournisseur entity);
    Fournisseur toEntity(FournisseurDto dto);

//    public FournisseurDto FromFournisseur(Fournisseur fournisseur){
//        FournisseurDto fournisseurDto = new FournisseurDto();
//        BeanUtils.copyProperties(fournisseur,fournisseurDto);
//        return fournisseurDto;
//    }
//
//    public Fournisseur FromFournisseurDto(FournisseurDto fournisseurDto){
//        Fournisseur fournisseur = new Fournisseur();
//        BeanUtils.copyProperties(fournisseurDto,fournisseur);
//        return fournisseur;
//    }
}
