package com.rj.spring.services.services.persistence.crud;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.rj.spring.services.services.persistence.entity.Compra;

public interface CompraCrudRepository extends CrudRepository<Compra, Integer> {

	Optional<List<Compra>> findByIdCliente(String idClient);

}
