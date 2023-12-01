package com.rj.practices.service.repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.rj.practices.service.dto.UpdatePizzaPriceDto;
import com.rj.practices.service.entity.PizzaEntity;

@Repository
public interface PizzaRepository extends ListCrudRepository<PizzaEntity, Integer> {

	List<PizzaEntity> findAllByAvailableTrueOrderByPrice();

	Optional<PizzaEntity> findFirstByAvailableTrueAndNameIgnoreCase(String name);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionContainingIgnoreCase(String ingredient);

	List<PizzaEntity> findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(String ingredient);

	List<PizzaEntity> findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceDesc(BigDecimal price);

	int countByVeganTrue();
	
	@Query(nativeQuery = true, value = "UPDATE pizza SET price = :#{#updatePizzaPriceDto.price} WHERE id_pizza = :#{#updatePizzaPriceDto.idPizza}")
	@Modifying
	void updatePrice(@Param("updatePizzaPriceDto") UpdatePizzaPriceDto updatePizzaPriceDto);

}
