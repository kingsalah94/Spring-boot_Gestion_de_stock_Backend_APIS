package com.salah.gestiondestock.Web.strategy;

import java.io.InputStream;

import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.flickr4java.flickr.FlickrException;
import com.salah.gestiondestock.Dtos.ArticlesDto;
import com.salah.gestiondestock.Enums.ErrorCodes;
import com.salah.gestiondestock.Exceptions.InvalidOperationException;
import com.salah.gestiondestock.Services.ArticlesService;
import com.salah.gestiondestock.Services.FlickrService;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Service("articlestrategy")
@AllArgsConstructor
@NoArgsConstructor
public class SaveArticlePhoto implements Strategy<ArticlesDto>{

    private FlickrService flickrService;
    private ArticlesService articleService;

  @Override
  public ArticlesDto savePhoto(Integer id, InputStream photo, String titre) throws FlickrException {
    ArticlesDto article = articleService.findById(id);
    String urlPhoto = flickrService.savePhoto(photo, titre);
    if (!StringUtils.hasLength(urlPhoto)) {
      throw new InvalidOperationException("Erreur lors de l'enregistrement de photo de l'article", ErrorCodes.UPDATE_PHOTO_EXCEPTION);
    }
    article.setPhoto(urlPhoto);
    return articleService.save(article);
  }
}
