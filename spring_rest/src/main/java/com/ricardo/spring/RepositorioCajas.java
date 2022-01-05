package com.ricardo.spring;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "art",
                        path = "art")
public interface RepositorioCajas extends PagingAndSortingRepository<Articulo, Long> {

}
