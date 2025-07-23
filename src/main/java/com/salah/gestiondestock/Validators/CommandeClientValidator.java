package com.salah.gestiondestock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.salah.gestiondestock.Dtos.CommandClientDto;

public class CommandeClientValidator {


  public static List<String> validate(CommandClientDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le code de la commande client");
      errors.add("Veuillez renseigner la date de la commande");
      errors.add("Veuillez renseigner l'etat de la commande");
      errors.add("Veuillez renseigner le client");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCode())) {
      errors.add("Veuillez renseigner le code de la commande client");
    }
    if (dto.getDateCommande() == null) {
      errors.add("Veuillez renseigner la date de la commande");
    }
    if (!StringUtils.hasLength(dto.getEtatCommande().toString())) {
      errors.add("Veuillez renseigner l'etat de la commande");
    }
    if (dto.getClientDto() == null || dto.getClientDto().getId() == null) {
      errors.add("Veuillez renseigner le client");
    }

    return errors;
  }

}

