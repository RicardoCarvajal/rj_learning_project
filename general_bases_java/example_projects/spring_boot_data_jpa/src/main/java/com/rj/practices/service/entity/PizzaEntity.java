package com.rj.practices.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.rj.practices.service.audit.AuditPizzaListener;
import com.rj.practices.service.audit.AuditableEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The persistent class for the pizza database table.
 * 
 */
@Entity
@Table(name = "pizza")
@EntityListeners({ AuditingEntityListener.class, AuditPizzaListener.class })
public class PizzaEntity extends AuditableEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_pizza")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idPizza;

	@Column(nullable = false, length = 150)
	private String description;

	@Column(nullable = false, length = 30, unique = true)
	private String name;

	@Column(nullable = false, columnDefinition = "Decimal(5,2)")
	private BigDecimal price;

	@Column(columnDefinition = "TINYINT")
	private boolean vegan;

	@Column(columnDefinition = "TINYINT")
	private boolean vegetarian;

	@Column(columnDefinition = "TINYINT")
	private boolean available;

	public Integer getIdPizza() {
		return this.idPizza;
	}

	public void setIdPizza(Integer idPizza) {
		this.idPizza = idPizza;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getPrice() {
		return this.price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public boolean isVegan() {
		return vegan;
	}

	public void setVegan(boolean vegan) {
		this.vegan = vegan;
	}

	public boolean isVegetarian() {
		return vegetarian;
	}

	public void setVegetarian(boolean vegetarian) {
		this.vegetarian = vegetarian;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "PizzaEntity: \n[idPizza=" + idPizza + ", description=" + description + ", name=" + name + ", price="
				+ price + ", vegan=" + vegan + ", vegetarian=" + vegetarian + ", available=" + available + "]\n";
	}

}