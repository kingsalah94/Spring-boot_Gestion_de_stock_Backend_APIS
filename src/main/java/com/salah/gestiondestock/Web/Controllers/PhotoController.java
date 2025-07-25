package com.salah.gestiondestock.Web.Controllers;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.flickr4java.flickr.FlickrException;
import com.salah.gestiondestock.Web.Api.PhotoApi;
import com.salah.gestiondestock.Web.strategy.StrategyPhotoContext;


@RestController
public class PhotoController implements PhotoApi{

    private StrategyPhotoContext strategyPhotoContext;

   @Autowired
  public PhotoController(StrategyPhotoContext strategyPhotoContext) {
    this.strategyPhotoContext = strategyPhotoContext;
  }

  @Override
  public Object savePhoto(String context, Integer id, MultipartFile photo, String title) throws IOException, FlickrException {
    return strategyPhotoContext.savePhoto(context, id, photo.getInputStream(), title);
  }

}
