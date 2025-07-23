package com.salah.gestiondestock.Validators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.salah.gestiondestock.Dtos.VentesDto;

public class VentesValidator {
    public static List<String> validate(VentesDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner le code de la commande");
      errors.add("Veuillez renseigner la date de la commande");
      return errors;
    }

    if (!StringUtils.hasLength(dto.getCode())) {
      errors.add("Veuillez renseigner le code de la commande");
    }
    if (dto.getDateVente() == null) {
      errors.add("Veuillez renseigner la date de la commande");
    }

    return errors;
  }
}
