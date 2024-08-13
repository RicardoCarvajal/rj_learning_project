package com.ricardo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ricardo.models.Articulo;
import com.ricardo.repositories.RepositorioArticulo;

@Service
public class ArticuloServicesImpl implements ArticuloServices {

    @Autowired
    private RepositorioArticulo repositorioArticulo;

    @Override
    public List<Articulo> findAll() {
        return repositorioArticulo.findAll();
    }

    @Override
    public void save(Articulo article) {
        repositorioArticulo.saveAndFlush(article);

    }

    @Override
    public void saveAll(List<Articulo> articles) {
        repositorioArticulo.save(articles);
    }

}
