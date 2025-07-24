package com.salah.gestiondestock.Web.Api;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Dtos.LigneCommandeClientDto;
import com.salah.gestiondestock.Dtos.LigneCommandeFournisseurDto;
import com.salah.gestiondestock.Dtos.LigneVenteDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salah.gestiondestock.Utils.Constants.APP_ROOT;

import io.swagger.v3.oas.annotations.tags.Tag;


@Tag(name = "Articles", description = "API pour la gestion des articles")
public interface ArticlesApi {

  @PostMapping(value = APP_ROOT + "/articles/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Enregistrer un article",
          description = "Cette méthode permet d'enregistrer ou modifier un article"
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "L'objet article créé / modifié"),
          @ApiResponse(responseCode = "400", description = "L'objet article n'est pas valide")
  })
  ArticlesDto save(@RequestBody ArticlesDto dto);

  @GetMapping(value = APP_ROOT + "/articles/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Rechercher un article par ID",
          description = "Cette méthode permet de chercher un article par son ID"
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "L'article a été trouvé dans la BDD"),
          @ApiResponse(responseCode = "404", description = "Aucun article trouvé avec l'ID fourni")
  })
  ArticlesDto findById(@PathVariable("idArticle") Integer id);

  @GetMapping(value = APP_ROOT + "/articles/filter/{codeArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Rechercher un article par CODE",
          description = "Cette méthode permet de chercher un article par son CODE"
  )
  @ApiResponses(value = {
          @ApiResponse(responseCode = "200", description = "L'article a été trouvé dans la BDD"),
          @ApiResponse(responseCode = "404", description = "Aucun article trouvé avec le CODE fourni")
  })
  ArticlesDto findByCodeArticle(@PathVariable("codeArticle") String codeArticle);

  @GetMapping(value = APP_ROOT + "/articles/all", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Renvoyer la liste des articles",
          description = "Cette méthode permet de chercher et renvoyer la liste des articles existants en base"
  )
  @ApiResponse(responseCode = "200", description = "La liste des articles / une liste vide")
  List<ArticlesDto> findAll();

  @GetMapping(value = APP_ROOT + "/articles/historique/vente/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Historique des ventes d’un article",
          description = "Retourne la liste des ventes liées à un article"
  )
  List<LigneVenteDto> findHistoriqueVentes(@PathVariable("idArticle") Integer idArticle);

  @GetMapping(value = APP_ROOT + "/articles/historique/commandeclient/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Historique des commandes clients d’un article",
          description = "Retourne la liste des commandes clients liées à un article"
  )
  List<LigneCommandeClientDto> findHistoriaueCommandeClient(@PathVariable("idArticle") Integer idArticle);

  @GetMapping(value = APP_ROOT + "/articles/historique/commandefournisseur/{idArticle}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Historique des commandes fournisseurs d’un article",
          description = "Retourne la liste des commandes fournisseurs liées à un article"
  )
  List<LigneCommandeFournisseurDto> findHistoriqueCommandeFournisseur(@PathVariable("idArticle") Integer idArticle);

  @GetMapping(value = APP_ROOT + "/articles/filter/category/{idCategory}", produces = MediaType.APPLICATION_JSON_VALUE)
  @Operation(
          summary = "Articles d’une catégorie",
          description = "Retourne la liste des articles liés à une catégorie donnée"
  )
  List<ArticlesDto> findAllArticleByIdCategory(@PathVariable("idCategory") Integer idCategory);

  @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
  @Operation(
          summary = "Supprimer un article",
          description = "Cette méthode permet de supprimer un article par son ID"
  )
  @ApiResponse(responseCode = "200", description = "L'article a été supprimé")
  void delete(@PathVariable("idArticle") Integer id);
}

