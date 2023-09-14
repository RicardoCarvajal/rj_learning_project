package com.rj.practices.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "order_item")
@IdClass(OrderItemId.class)
public class OrderItemEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_item", nullable = false)
	private Integer idItem;

	@Id
	@Column(name = "id_order", nullable = false)
	private Integer idOrder;

	@Column(name = "id_pizza", nullable = false)
	private Integer idPizza;

	private BigDecimal price;

	private BigDecimal quantity;

	@ManyToOne
	@JoinColumn(name = "id_pizza", referencedColumnName = "id_pizza", insertable = false, updatable = false)
	private PizzaEntity pizza;

	@ManyToOne
	@JoinColumn(name = "id_order", referencedColumnName = "id_order", insertable = false, updatable = false)
	@JsonIgnore
	private PizzaOrderEntity pizzaOrder;

	public Integer getIdItem() {
		return idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	public Integer getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(Integer idOrder) {
		this.idOrder = idOrder;
	}

	public Integer getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public PizzaEntity getPizza() {
		return pizza;
	}

	public void setPizza(PizzaEntity pizza) {
		this.pizza = pizza;
	}

	public PizzaOrderEntity getPizzaOrder() {
		return pizzaOrder;
	}

	public void setPizzaOrder(PizzaOrderEntity pizzaOrder) {
		this.pizzaOrder = pizzaOrder;
	}

}