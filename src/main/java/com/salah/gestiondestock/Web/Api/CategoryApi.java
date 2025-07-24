package com.salah.gestiondestock.Web.Api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import com.salah.gestiondestock.Dtos.CategoryDto;

import static com.salah.gestiondestock.Utils.Constants.APP_ROOT;

import java.util.List;


@Tag(name = "Catégories", description = "API pour la gestion des catégories d'articles")
public interface CategoryApi {

    @PostMapping(value = APP_ROOT + "/categories/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Créer ou modifier une catégorie",
            description = "Cette méthode permet d'enregistrer ou modifier une catégorie"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie créée / modifiée"),
            @ApiResponse(responseCode = "400", description = "La catégorie n'est pas valide")
    })
    CategoryDto save(@RequestBody CategoryDto dto);

    @GetMapping(value = APP_ROOT + "/categories/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Rechercher une catégorie par ID",
            description = "Cette méthode permet de chercher une catégorie par son ID"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie trouvée"),
            @ApiResponse(responseCode = "404", description = "Aucune catégorie trouvée avec cet ID")
    })
    CategoryDto findById(@PathVariable("idCategory") Integer id);

    @GetMapping(value = APP_ROOT + "/categories/filter/{codeCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Rechercher une catégorie par CODE",
            description = "Cette méthode permet de chercher une catégorie par son CODE"
    )
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Catégorie trouvée"),
            @ApiResponse(responseCode = "404", description = "Aucune catégorie trouvée avec ce CODE")
    })
    CategoryDto findByCode(@PathVariable("codeCategory") String code);

    @GetMapping(value = APP_ROOT + "/categories/all", produces = MediaType.APPLICATION_JSON_VALUE)
    @Operation(
            summary = "Lister toutes les catégories",
            description = "Cette méthode retourne la liste des catégories enregistrées"
    )
    @ApiResponse(responseCode = "200", description = "Liste des catégories ou liste vide")
    List<CategoryDto> findAll();

    @DeleteMapping(value = APP_ROOT + "/categories/delete/{idCategory}")
    @Operation(
            summary = "Supprimer une catégorie",
            description = "Cette méthode permet de supprimer une catégorie par ID"
    )
    @ApiResponse(responseCode = "200", description = "Catégorie supprimée avec succès")
    void delete(@PathVariable("idCategory") Integer id);
}
