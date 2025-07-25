package com.salah.gestiondestock.Web.strategy;

import java.io.InputStream;

import com.flickr4java.flickr.FlickrException;

public interface Strategy<T> {
    T savePhoto(Integer id, InputStream photo, String titre) throws FlickrException;
}
