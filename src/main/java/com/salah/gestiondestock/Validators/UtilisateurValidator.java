package com.salah.gestiondestock.Validators;

import com.salah.gestiondestock.Dtos.UtilisateurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class UtilisateurValidator {

    public static List<String> validate(UtilisateurDto utilisateurDto){
        List<String> errors =new ArrayList<>();

        if(utilisateurDto == null){
            errors.add("Veuiller renseigner le nom d'utilisateur");
            errors.add("Veuiller renseigner le prenom d'utilisateur");
            errors.add("Veuiller renseigner le mot de passe de l'utilisateur");
            errors.add("Veuiller renseigner l'email de l'utilisateur");
            errors.add("Veuiller renseigner l'adresse de l'utilisateur");
            return errors;
        }


        if(!StringUtils.hasLength(utilisateurDto.getNom())){
            errors.add("Veuiller renseigner le nom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getPrenom())){
            errors.add("Veuiller renseigner le prenom d'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getMotDePasse())){
            errors.add("Veuiller renseigner le mot de passe de l'utilisateur");
        }
        if(!StringUtils.hasLength(utilisateurDto.getEmail())){
            errors.add("Veuiller renseigner l'email de l'utilisateur");
        }
        if(utilisateurDto.getDateDeNaissance()== null){
            errors.add("Veuiller renseigner la de naissance de l'utilisateur");
        }
        if(utilisateurDto.getAdresseDto()== null){
            errors.add("Veuiller renseigner l'adresse de l'utilisateur");
        }else {
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getAdresse1())){
                errors.add("le champs 'Address 1' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getVille())){
                errors.add("le champs 'Ville' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getCodePostale())){
                errors.add("le champs 'Code Postal' est obligatoire");
            }
            if(!StringUtils.hasLength(utilisateurDto.getAdresseDto().getPays())){
                errors.add("le champs 'Pays' est obligatoire");
            }


        }

        return errors;
    }
}
