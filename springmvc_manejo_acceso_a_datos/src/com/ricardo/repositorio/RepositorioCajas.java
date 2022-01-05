package com.ricardo.repositorio;

import org.springframework.data.repository.CrudRepository;

import com.ricardo.model.entity.Caja;

public interface RepositorioCajas extends CrudRepository<Caja, Long> {

}
