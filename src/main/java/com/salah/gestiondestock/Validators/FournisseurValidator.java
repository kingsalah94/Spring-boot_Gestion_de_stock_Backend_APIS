package com.salah.gestiondestock.Validators;

import com.salah.gestiondestock.Dtos.FournisseurDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class FournisseurValidator {

    public static List<String> validate(FournisseurDto fournisseurDto){
        List<String> errors = new ArrayList<>();

        if (fournisseurDto == null){
            errors.add("Veuiller renseigner le Nom du Fournisseur");
            errors.add("Veuiller renseigner le Prenom du Fournisseur");
            errors.add("Veuiller renseigner l'email du Fournisseur");
            errors.add("Veuiller renseigner le numeros de telephone du Fournisseur");

            return errors;
        }
        if (!StringUtils.hasLength(fournisseurDto.getNom())){
            errors.add("Veuiller renseigner le Nom du Fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getPrenom())){
            errors.add("Veuiller renseigner le Prenom du Fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getEmail())){
            errors.add("Veuiller renseigner l'email du Fournisseur");
        }
        if (!StringUtils.hasLength(fournisseurDto.getNumTel())){
            errors.add("Veuiller renseigner le numeros de telephone du Fournisseur");
        }

        return errors;
    }
}
