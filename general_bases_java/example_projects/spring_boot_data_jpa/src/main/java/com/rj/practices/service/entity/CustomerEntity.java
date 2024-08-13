package com.rj.practices.service.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * The persistent class for the customer database table.
 * 
 */
@Entity
@Table(name = "customer")
public class CustomerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "id_customer")
	private String idCustomer;

	@Column(nullable = false, length = 100)
	private String address;

	@Column(length = 50)
	private String email;

	@Column(nullable = false, length = 60)
	private String name;

	@Column(name = "phone_number", length = 20)
	private String phoneNumber;

	public String getIdCustomer() {
		return this.idCustomer;
	}

	public void setIdCustomer(String idCustomer) {
		this.idCustomer = idCustomer;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "CustomerEntity [Identificador de cliente =" + idCustomer + ", nombre=" + name + "]";
	}

}