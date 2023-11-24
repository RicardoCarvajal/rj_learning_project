package com.intelix.sofka.app.entitys;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "customers")
public class Customer {

	@Id
	private String id;
	private String name;
	private String direction;
	private String type;
	private String phone;

	@OneToOne(mappedBy = "customer")
	private Account idAccount;

	public Customer() {

	}

	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getDirection() {
		return direction;
	}

	public String getType() {
		return type;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* Builder */

	public static Customer createCustomer() {
		return new Customer();
	}

	public Customer id(String id) {
		this.id = id;
		return this;
	}

	public Customer name(String name) {
		this.name = name;
		return this;
	}

	public Customer direction(String direction) {
		this.direction = direction;
		return this;
	}

	public Customer type(String type) {
		this.type = type;
		return this;
	}

	public Customer phone(String phone) {
		this.phone = phone;
		return this;
	}

	public Customer build() {
		return this;
	}

}
