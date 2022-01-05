package com.ricardo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ricardo.models.Articulo;

public interface RepositorioArticulo extends JpaRepository<Articulo, Long> {

}
