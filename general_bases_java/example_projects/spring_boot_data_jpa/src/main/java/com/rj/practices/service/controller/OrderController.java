package com.rj.practices.service.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rj.practices.service.dto.RandomOrderDto;
import com.rj.practices.service.entity.PizzaOrderEntity;
import com.rj.practices.service.proyection.OrderSummary;
import com.rj.practices.service.services.OrderService;

@RestController
@RequestMapping("/api/order")
public class OrderController {

	private final OrderService orderService;

	@Autowired
	public OrderController(OrderService orderService) {
		this.orderService = orderService;
	}

	@GetMapping
	public ResponseEntity<List<PizzaOrderEntity>> getAll() {

		List<PizzaOrderEntity> orders = orderService.getAll();

		orders.forEach(o -> System.out.println(o.getCustomer()));

		return ResponseEntity.ok(orders);
	}

	@GetMapping("/customer/{idCustomer}")
	public ResponseEntity<List<PizzaOrderEntity>> getByCustomer(@PathVariable String idCustomer) {
		List<PizzaOrderEntity> orders = orderService.getByCustomer(idCustomer);
		return ResponseEntity.ok(orders);
	}

	@GetMapping("/today")
	public ResponseEntity<List<PizzaOrderEntity>> getToday() {

		return ResponseEntity.ok(orderService.getTodayOrder());

	}

	@GetMapping("/outside")
	public ResponseEntity<List<PizzaOrderEntity>> getOutsideOreders() {
		return ResponseEntity.ok(orderService.getOutsideOrders());
	}

	@GetMapping("/summary/{id}")
	public ResponseEntity<OrderSummary> getSummary(@PathVariable int id) {
		return ResponseEntity.ok(orderService.getSummary(id));
	}

	@PostMapping("/random")
	public ResponseEntity<Boolean> saveRandomOrder(@RequestBody RandomOrderDto request) {
		return ResponseEntity.ok(orderService.saveRandomOrder(request));
	}

}
