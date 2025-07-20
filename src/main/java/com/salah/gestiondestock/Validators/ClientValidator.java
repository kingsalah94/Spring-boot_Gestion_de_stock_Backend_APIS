package com.salah.gestiondestock.Validators;

import com.salah.gestiondestock.Dtos.ClientDto;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class ClientValidator {
    public static List<String> validate(ClientDto clientDto){
        List<String> errors = new ArrayList<>();

        if (clientDto == null){
            errors.add("Veuiller renseigner le Nom du client");
            errors.add("Veuiller renseigner le Prenom du client");
            errors.add("Veuiller renseigner l'email du client");
            errors.add("Veuiller renseigner le Numeros de telephone du client");
            return errors;
        }

        if (!StringUtils.hasLength(clientDto.getNom())){
            errors.add("Veuiller renseigner le Nom du client");
        }
        if (!StringUtils.hasLength(clientDto.getPrenom())){
            errors.add("Veuiller renseigner le Prenom du client");
        }
        if (!StringUtils.hasLength(clientDto.getEmail())){
            errors.add("Veuiller renseigner l'email du client");
        }
        if (!StringUtils.hasLength(clientDto.getNumTel())){
            errors.add("Veuiller renseigner le Numeros de telephone du client");
        }
        return errors;
    }
}
