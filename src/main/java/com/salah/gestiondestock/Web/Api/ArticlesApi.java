package com.salah.gestiondestock.Web.Api;

import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Exceptions.EntityNotFoundException;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.salah.gestiondestock.Utils.Constants.APP_ROOT;

public interface ArticlesApi {

    @PostMapping(value = APP_ROOT + "/articles/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    ArticlesDto addArticles(@RequestBody ArticlesDto articlesDto);

//    @PutMapping(value = APP_ROOT + "/articles/updateArticle", produces = MediaType.APPLICATION_JSON_VALUE, consumes = MediaType.APPLICATION_JSON_VALUE)
//    ArticlesDto updateArticles(@RequestBody ArticlesDto articlesDto);

    @DeleteMapping(value = APP_ROOT + "/articles/delete/{idArticle}")
    void deleteArticles(@PathVariable("idArticle") Integer id);

    @GetMapping(value = APP_ROOT + "/articles/{idArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
    ArticlesDto getOneArticles(@PathVariable("idArticle") Integer id) throws EntityNotFoundException;

//    @GetMapping(value = APP_ROOT + "/articles/{codeArticle}",produces = MediaType.APPLICATION_JSON_VALUE)
//    ArticlesDto getArticleByCodeArticle(@PathVariable("codeArticle") String codeArticle) throws EntityNotFoundException;

    @GetMapping(value = APP_ROOT + "/articles/AllArticles",produces = MediaType.APPLICATION_JSON_VALUE)
    List<ArticlesDto> getAllArticles();

}
