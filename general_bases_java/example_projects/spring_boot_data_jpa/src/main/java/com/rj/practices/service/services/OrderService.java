package com.rj.practices.service.services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rj.practices.service.dto.RandomOrderDto;
import com.rj.practices.service.entity.PizzaOrderEntity;
import com.rj.practices.service.proyection.OrderSummary;
import com.rj.practices.service.repository.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	private final OrderRepository orderRepository;

	@Autowired
	public OrderService(OrderRepository orderRepository) {
		this.orderRepository = orderRepository;
	}

	public List<PizzaOrderEntity> getAll() {
		return orderRepository.findAll();
	}

	public OrderSummary getSummary(int id) {
		return this.orderRepository.findSummary(id);
	}

	public List<PizzaOrderEntity> getByCustomer(String idCustomer) {
		return orderRepository.findCustomerOrders(idCustomer);
	}

	public List<PizzaOrderEntity> getTodayOrder() {
		LocalDateTime today = LocalDate.now().atTime(0, 0);

		return orderRepository.findAllByDateAfter(today);
	}

	public List<PizzaOrderEntity> getOutsideOrders() {

		List<String> methods = Arrays.asList("D", "C");

		return orderRepository.findAllByMethodIn(methods);
	}

	@Transactional
	public boolean saveRandomOrder(RandomOrderDto request) {
		return orderRepository.saveRandomOrder(request.getIdCustomer(), request.getMethod());
	}

}
