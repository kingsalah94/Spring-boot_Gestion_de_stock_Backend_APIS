package com.salah.gestiondestock.Validators;

import com.salah.gestiondestock.Dtos.EntrepriseDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class EntrepriseValisator {

    public static List<String> validate(EntrepriseDto entreprise) {
        List<String> errors = new ArrayList<>();

        if(entreprise == null){
            errors.add("Veuillez renseigner le nom de l'entreprise");
            errors.add("Veuillez renseigner la description de l'entreprise");
            errors.add("Veuillez renseigner le codeFiscal de l'entreprise");
            errors.add("Veuillez renseigner le mail de l'entreprise");
            return errors;
        }

        if (!StringUtils.hasLength(entreprise.getNom())){
            errors.add("Veuillez renseigner le nom de l'entreprise");
        }
        if (!StringUtils.hasLength(entreprise.getDescription())){
            errors.add("Veuillez renseigner le description de l'entreprise");
        }
        if (!StringUtils.hasLength(entreprise.getCodeFiscal())){
            errors.add("Veuillez renseigner le codeFiscal de l'entreprise");
        }
        if (!StringUtils.hasLength(entreprise.getEmail())){
            errors.add("Veuillez renseigner le email de l'entreprise");
        }
        return errors;
    }
}
