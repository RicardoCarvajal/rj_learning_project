package com.rj.practices.service.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;

/**
 * The persistent class for the pizza_order database table.
 * 
 */
@Entity
@Table(name = "pizza_order")
public class PizzaOrderEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_order", nullable = false)
	private Integer idOrder;

	@Column(name = "id_customer", nullable = false)
	private String idCustomer;

	@Column(name = "additional_notes", length = 200)
	private String additionalNotes;

	@Column(nullable = false, columnDefinition = "DATETIME")
	private LocalDateTime date;

	@Column(nullable = false, columnDefinition = "CHAR(1)")
	private String method;

	@Column(nullable = false, columnDefinition = "DECIMAL(6,2)")
	private BigDecimal total;

	@OneToMany(mappedBy = "pizzaOrder", fetch = FetchType.EAGER)
	@OrderBy("price DESC")
	private List<OrderItemEntity> orderItems;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_customer", referencedColumnName = "id_customer", insertable = false, updatable = false)
	@JsonIgnore
	private CustomerEntity customer;

	public String getIdCustomer() {
		return idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public CustomerEntity getCustomer() {
		return customer;
	}

	public void setCustomer(CustomerEntity customer) {
		this.customer = customer;
	}

	public int getIdOrder() {
		return this.idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getAdditionalNotes() {
		return this.additionalNotes;
	}

	public void setAdditionalNotes(String additionalNotes) {
		this.additionalNotes = additionalNotes;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getMethod() {
		return this.method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public BigDecimal getTotal() {
		return this.total;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	public List<OrderItemEntity> getOrderItems() {
		return this.orderItems;
	}

	public void setOrderItems(List<OrderItemEntity> orderItems) {
		this.orderItems = orderItems;
	}

}