package com.sofka.services.app.drivenAdapter.repository;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import com.sofka.services.app.entity.Reverso;

public interface IRevertRepository extends ReactiveMongoRepository<Reverso, String> {

}
