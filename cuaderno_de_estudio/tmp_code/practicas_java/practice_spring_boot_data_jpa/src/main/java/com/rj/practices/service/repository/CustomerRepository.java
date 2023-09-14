package com.rj.practices.service.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rj.practices.service.entity.CustomerEntity;

@Repository
public interface CustomerRepository extends ListCrudRepository<CustomerEntity, String> {

	@Query(value = "select c from CustomerEntity c where c.phoneNumber = :phone")
	CustomerEntity findByPhone(@Param("phone") String phone);

}
