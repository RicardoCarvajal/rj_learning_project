package com.ricardo.services;

import java.util.List;

import com.ricardo.models.Articulo;

public interface ArticuloServices {

    List<Articulo> findAll();

    void save(Articulo article);

    void saveAll(List<Articulo> articles);

}
