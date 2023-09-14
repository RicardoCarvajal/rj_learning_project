package com.rj.practices.service.services;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.rj.practices.service.dto.UpdatePizzaPriceDto;
import com.rj.practices.service.entity.PizzaEntity;
import com.rj.practices.service.repository.PizzaPagSortRepository;
import com.rj.practices.service.repository.PizzaRepository;

@Service
public class PizzaService {

	private final PizzaRepository pizzaRepository;
	private final PizzaPagSortRepository pizzaPagSortRepository;

	@Autowired
	public PizzaService(PizzaRepository pizzaRepository, PizzaPagSortRepository pizzaPagSortRepository) {
		this.pizzaRepository = pizzaRepository;
		this.pizzaPagSortRepository = pizzaPagSortRepository;
	}

	public Page<PizzaEntity> getAll(int page, int elements) {
		Pageable pageable = PageRequest.of(page, elements);
		return pizzaPagSortRepository.findAll(pageable);
	}

	public PizzaEntity get(Integer id) {
		return this.pizzaRepository.findById(id).orElse(null);
	}

	public PizzaEntity getByName(String name) {
		return this.pizzaRepository.findFirstByAvailableTrueAndNameIgnoreCase(name)
				.orElseThrow(() -> new RuntimeException("la pizza no existe"));
	}

	public Page<PizzaEntity> getAvailable(int page, int elements, String sortBy, String sortDirection) {
		System.out.println(pizzaRepository.countByVeganTrue());

		Sort sort = Sort.by(Sort.Direction.fromString(sortDirection), sortBy);

		Pageable pageable = PageRequest.of(page, elements, sort);
		return this.pizzaPagSortRepository.findByAvailableTrue(pageable);
	}

	public List<PizzaEntity> getByPrice(BigDecimal price) {
		return this.pizzaRepository.findTop3ByAvailableTrueAndPriceLessThanEqualOrderByPriceDesc(price);
	}

	public List<PizzaEntity> getConteining(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionContainingIgnoreCase(ingredient);
	}

	public List<PizzaEntity> getNotConteining(String ingredient) {
		return this.pizzaRepository.findAllByAvailableTrueAndDescriptionNotContainingIgnoreCase(ingredient);
	}

	public PizzaEntity save(PizzaEntity pizzaEntity) {
		return this.pizzaRepository.save(pizzaEntity);
	}

	@Transactional(noRollbackFor = NullPointerException.class, propagation = Propagation.REQUIRED)
	public void updatePrice(UpdatePizzaPriceDto updatePizzaPriceDto) {
		this.pizzaRepository.updatePrice(updatePizzaPriceDto);
	}

	public void delete(Integer id) {
		this.pizzaRepository.deleteById(id);
	}

	public boolean exists(Integer id) {
		return this.pizzaRepository.existsById(id);
	}

}
