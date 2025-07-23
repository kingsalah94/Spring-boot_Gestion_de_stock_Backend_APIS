package com.salah.gestiondestock.Validators;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.springframework.util.StringUtils;

import com.salah.gestiondestock.Dtos.MouvementDeStockDto;

public class MvtStkValidator {
    public static List<String> validate(MouvementDeStockDto dto) {
    List<String> errors = new ArrayList<>();
    if (dto == null) {
      errors.add("Veuillez renseigner la date du mouvenent");
      errors.add("Veuillez renseigner la quantite du mouvenent");
      errors.add("Veuillez renseigner l'article");
      errors.add("Veuillez renseigner le type du mouvement");

      return errors;
    }
    if (dto.getDateMouvement() == null) {
      errors.add("Veuillez renseigner la date du mouvenent");
    }
    if (dto.getQuantite() == null || dto.getQuantite().compareTo(BigDecimal.ZERO) == 0) {
      errors.add("Veuillez renseigner la quantite du mouvenent");
    }
    if (dto.getArticlesDto() == null || dto.getArticlesDto().getId() == null) {
      errors.add("Veuillez renseigner l'article");
    }
    if (!StringUtils.hasLength(dto.getTypeMouvementStock().name())) {
      errors.add("Veuillez renseigner le type du mouvement");
    }

    return errors;
  }

}
