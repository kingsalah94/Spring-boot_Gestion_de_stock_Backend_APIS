package com.salah.gestiondestock.DtoMappers;

import com.salah.gestiondestock.Dtos.EntrepriseDto;
import com.salah.gestiondestock.model.Entreprise;
import org.mapstruct.Mapper;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

@Mapper(componentModel = "spring", uses = {AdresseMapper.class, UtilisateurMapper.class})
public interface EntrepriseMapper {
    EntrepriseDto toDto(Entreprise entity);
    Entreprise toEntity(EntrepriseDto dto);

//    public EntrepriseDto fromEntreprise(Entreprise entreprise){
//        EntrepriseDto entrepriseDto = new EntrepriseDto();
//        BeanUtils.copyProperties(entreprise,entrepriseDto);
//        return entrepriseDto;
//    }
//
//    public Entreprise FromEntrepriseDto(EntrepriseDto entrepriseDto){
//        Entreprise entreprise = new Entreprise();
//        BeanUtils.copyProperties(entrepriseDto,entreprise);
//        return entreprise;
//    }
}
