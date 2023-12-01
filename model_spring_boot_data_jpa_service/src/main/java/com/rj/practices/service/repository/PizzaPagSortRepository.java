package com.rj.practices.service.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.ListPagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.rj.practices.service.entity.PizzaEntity;

@Repository
public interface PizzaPagSortRepository extends ListPagingAndSortingRepository<PizzaEntity, Integer> {

	Page<PizzaEntity> findByAvailableTrue(Pageable pageable);

}
