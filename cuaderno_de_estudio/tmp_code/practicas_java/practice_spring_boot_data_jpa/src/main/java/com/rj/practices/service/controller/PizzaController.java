package com.rj.practices.service.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.rj.practices.service.dto.UpdatePizzaPriceDto;
import com.rj.practices.service.entity.PizzaEntity;
import com.rj.practices.service.services.PizzaService;

@RestController
@RequestMapping("/api/pizza")
public class PizzaController {

	private final PizzaService pizzaService;

	@Autowired
	public PizzaController(PizzaService pizzaService) {
		this.pizzaService = pizzaService;
	}

	@GetMapping
	public ResponseEntity<Page<PizzaEntity>> getAll(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int elements) {
		return ResponseEntity.ok(this.pizzaService.getAll(page, elements));
	}

	@GetMapping("/available")
	public ResponseEntity<Page<PizzaEntity>> getAvailable(@RequestParam(defaultValue = "0") int page,
			@RequestParam(defaultValue = "10") int elements, @RequestParam(defaultValue = "price") String sortBy,
			@RequestParam(defaultValue = "ASC") String sortDirection) {
		return ResponseEntity.ok(this.pizzaService.getAvailable(page, elements, sortBy, sortDirection));
	}

	@GetMapping("/price/{price}")
	public ResponseEntity<List<PizzaEntity>> getByPrice(@PathVariable BigDecimal price) {
		return ResponseEntity.ok(this.pizzaService.getByPrice(price));
	}

	@GetMapping("/conteining/{ingredient}")
	public ResponseEntity<List<PizzaEntity>> getConteining(@PathVariable String ingredient) {
		return ResponseEntity.ok(this.pizzaService.getConteining(ingredient));
	}

	@GetMapping("/notconteining/{ingredient}")
	public ResponseEntity<List<PizzaEntity>> getNotConteining(@PathVariable String ingredient) {
		return ResponseEntity.ok(this.pizzaService.getNotConteining(ingredient));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PizzaEntity> get(@PathVariable Integer id) {
		if (id != null && this.pizzaService.exists(id))
			return ResponseEntity.ok(this.pizzaService.get(id));

		return ResponseEntity.notFound().build();
	}

	@GetMapping("/name/{name}")
	public ResponseEntity<PizzaEntity> getByName(@PathVariable String name) {
		return ResponseEntity.ok(this.pizzaService.getByName(name));
	}

	@PostMapping
	public ResponseEntity<PizzaEntity> add(@RequestBody PizzaEntity pizzaEntity) {
		if (pizzaEntity.getIdPizza() == null)
			return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));

		return ResponseEntity.badRequest().build();
	}

	@PutMapping
	public ResponseEntity<PizzaEntity> update(@RequestBody PizzaEntity pizzaEntity) {
		if (pizzaEntity.getIdPizza() != null && this.pizzaService.exists(pizzaEntity.getIdPizza()))
			return ResponseEntity.ok(this.pizzaService.save(pizzaEntity));

		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/price")
	public ResponseEntity<Void> updatePrice(@RequestBody UpdatePizzaPriceDto updatePizzaPriceDto) {
		if (updatePizzaPriceDto.getIdPizza() != 0 && this.pizzaService.exists(updatePizzaPriceDto.getIdPizza()) && updatePizzaPriceDto.getPrice() != null && updatePizzaPriceDto.getPrice().compareTo(BigDecimal.ZERO) >= 0) {
			this.pizzaService.updatePrice(updatePizzaPriceDto);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> delete(@PathVariable Integer id) {
		if (id != null && this.pizzaService.exists(id)) {
			this.pizzaService.delete(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.badRequest().build();

	}

}
