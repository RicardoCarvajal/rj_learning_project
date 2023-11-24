package com.intelix.sofka.app.dto;

import org.springframework.validation.annotation.Validated;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Validated
public class CustomerDto {

	@NotEmpty(message = "El id del cliente no debe ser nulo")
	@NotNull(message = "El id del cliente no debe ser nulo")
	private String id;

	@NotEmpty(message = "El nombre del cliente no debe ser nulo")
	@NotNull(message = "El nombre del cliente no debe ser nulo")
	private String name;

	@NotEmpty(message = "La dirección del cliente no debe ser nulo")
	@NotNull(message = "La dirección del cliente no debe ser nulo")
	private String direction;

	@NotEmpty(message = "El telefono del cliente no debe ser nulo")
	@NotNull(message = "El telefono del cliente no debe ser nulo")
	private String phone;

	public CustomerDto() {

	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDirection() {
		return direction;
	}

	public void setDirection(String direction) {
		this.direction = direction;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
