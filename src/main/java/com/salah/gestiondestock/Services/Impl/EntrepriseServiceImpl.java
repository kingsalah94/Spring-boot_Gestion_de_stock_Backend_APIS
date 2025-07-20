package com.salah.gestiondestock.Services.Impl;

import com.salah.gestiondestock.DtoMappers.EntrepriseMapper;
import com.salah.gestiondestock.Dtos.EntrepriseDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import com.salah.gestiondestock.Exceptions.InvalideEntityException;
import com.salah.gestiondestock.Repositories.EntrpriseRepository;
import com.salah.gestiondestock.Services.EntrepriseService;
import com.salah.gestiondestock.Validators.EntrepriseValisator;
import com.salah.gestiondestock.model.Entreprise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.View;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class EntrepriseServiceImpl implements EntrepriseService {

    private final View error;
    private EntrpriseRepository entrpriseRepository;
    private EntrepriseMapper dtoMapper;

    public EntrepriseServiceImpl(EntrpriseRepository entrpriseRepository, EntrepriseMapper dtoMapper, View error) {
        this.entrpriseRepository = entrpriseRepository;
        this.dtoMapper = dtoMapper;
        this.error = error;
    }

//    @Override
//    public EntrepriseDto addEntreprise(EntrepriseDto entreprisedto) {
//        List<String> errors = EntrepriseValisator.validate(entreprisedto);
//        if(!errors.isEmpty()) {
//            log.error("Error while adding Entreprise: {}",errors);
//
//            throw new InvalideEntityException("L'Entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALIDE,errors);
//        }
//        Entreprise entreprise = dtoMapper.FromEntrepriseDto(entreprisedto);
//        Entreprise savedEntreprise = entrpriseRepository.save(entreprise);
//        return dtoMapper.fromEntreprise(savedEntreprise);
//    }
//
//    @Override
//    public EntrepriseDto updateEntreprise(EntrepriseDto entreprisedto) {
//        List<String> errors = EntrepriseValisator.validate(entreprisedto);
//        if(!errors.isEmpty()) {
//            log.error("Error while updating Entreprise: {}",errors);
//            throw new InvalideEntityException("L'Entreprise n'est pas valide", ErrorCodes.ENTREPRISE_NOT_VALIDE,errors);
//        }
//        Entreprise entreprise = dtoMapper.FromEntrepriseDto(entreprisedto);
//        Entreprise savedEntreprise = entrpriseRepository.save(entreprise);
//        return dtoMapper.fromEntreprise(savedEntreprise);
//    }
//
//
//    @Override
//    public EntrepriseDto getEntrepriseById(Integer id) {
//        if(id == null){
//            log.error("Error while getting Entreprise by id: {}",error);
//            return null;
//        }
//        Entreprise entreprise = entrpriseRepository.findById(id)
//                .orElseThrow(()->new EntityNotFoundException("Entreprise not found", ErrorCodes.ENTREPRISE_NOT_FOUND));
//        return dtoMapper.fromEntreprise(entreprise);
//    }
//
//    @Override
//    public EntrepriseDto getEntrepriseByName(String name) {
//        if (StringUtils.hasLength(name)){
//            log.error("Error while getting Entreprise by name: {}",error);
//            return null;
//        }
//        Entreprise entreprise = entrpriseRepository.findEntrepriseByNom(name)
//                .orElseThrow(()->new EntityNotFoundException("Entreprise not Found",ErrorCodes.FOURNISSEUR_NOT_FOUND));
//        return null;
//    }
//
//    @Override
//    public List<EntrepriseDto> getAllEntreprise() {
//        List<Entreprise> entreprises = entrpriseRepository.findAll();
//        return entreprises.stream()
//                .map(entreprise-> dtoMapper.fromEntreprise(entreprise))
//                .collect(Collectors.toList());
//    }
//
//    @Override
//    public void deleteEntreprise(Integer id) {
//        if(id == null){
//            log.error("Error while deleting Entreprise by id: {}",error);
//            return;
//        }
//        entrpriseRepository.deleteById(id);
//    }
}
