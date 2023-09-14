package com.rj.practice.bases;

import java.util.Optional;

public class PracticeOptional {

	public static void main(String[] args) {

		Person i = new Person("Ricardo", "Carvajal",
				new Address("Callejon carabobo", "Venezuela", "Carabobo", "Valencia"));

		Optional<Person> box = Optional.ofNullable(i);

		String municipality = box.flatMap(Person::getAddress).map(Address::getMunicipality)
				.orElseGet(() -> "municipio no encontrado");

		System.out.println("Resultado: " + municipality);

	}

}

class Person {
	private String name;
	private String lastName;
	private Address address;

	public Person(String name, String lastName, Address address) {
		super();
		this.name = name;
		this.lastName = lastName;
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Optional<Address> getAddress() {
		return Optional.ofNullable(address);
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}

class Address {

	private String street;
	private String country;
	private String departament;
	private String municipality;

	public Address(String street, String country, String departament, String municipality) {
		super();
		this.street = street;
		this.country = country;
		this.departament = departament;
		this.municipality = municipality;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDepartament() {
		return departament;
	}

	public void setDepartament(String departament) {
		this.departament = departament;
	}

	public String getMunicipality() {
		return municipality;
	}

	public void setMunicipality(String municipality) {
		this.municipality = municipality;
	}

}