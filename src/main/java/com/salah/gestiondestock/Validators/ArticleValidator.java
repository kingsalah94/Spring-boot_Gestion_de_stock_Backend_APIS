package com.salah.gestiondestock.Validators;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class ArticleValidator {

    public static List<String> validate(ArticlesDto articlesDto){

        List<String> errors = new ArrayList<>();

        if (articlesDto == null){
            errors.add("Veuiller renseigner le code de l'article");
            errors.add("Veuiller renseigner la designation de l'article");
            errors.add("Veuiller renseigner le prix HT de l'article");
            errors.add("Veuiller renseigner le prix TTC de l'article");
            errors.add("Veuiller renseigner le taux TVA de l'article");
            errors.add("Veuiller renseigner la categorie de l'article");
            return errors;

        }


        if (!StringUtils.hasLength(articlesDto.getCodeArticle())){
            errors.add("Veuiller renseigner le code de l'article");
        }
        if (!StringUtils.hasLength(articlesDto.getDesignation())){
            errors.add("Veuiller renseigner la designation de l'article");
        }

        if (articlesDto.getPrixUnitaireHt() == null){
            errors.add("Veuiller renseigner le prix HT de l'article");
        }else if (articlesDto.getPrixUnitaireHt().compareTo(BigDecimal.ZERO) < 0) {
            errors.add("Le prix HT de l'article ne peut pas être négatif");
        }
        if (articlesDto.getPrixUnitaireTtc() == null){
            errors.add("Veuiller renseigner le prix TTC de l'article");
        }else if (articlesDto.getPrixUnitaireTtc().compareTo(BigDecimal.ZERO) < 0) {
            errors.add("Le prix TTC de l'article ne peut pas être négatif");
        }
        if (articlesDto.getTauxTva() == null){
            errors.add("Veuiller renseigner le taux TVA de l'article");
        }else if (articlesDto.getTauxTva().compareTo(BigDecimal.ZERO) < 0 || articlesDto.getTauxTva().compareTo(BigDecimal.valueOf(100)) > 0) {
            errors.add("Le taux TVA de l'article doit être compris entre 0 et 100");
        }

        if (articlesDto.getCategory()==null){
            errors.add("Veuiller renseigner la categorie de l'article");
        }

        return errors;

    }
}
