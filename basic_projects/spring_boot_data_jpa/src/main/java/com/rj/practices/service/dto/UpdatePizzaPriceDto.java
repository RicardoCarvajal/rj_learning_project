package com.rj.practices.service.dto;

import java.math.BigDecimal;

public class UpdatePizzaPriceDto {
	
	private int idPizza;
	private BigDecimal price;
	
	public UpdatePizzaPriceDto(int idPizza, BigDecimal price) {
		this.idPizza = idPizza;
		this.price = price;
	}

	public int getIdPizza() {
		return idPizza;
	}

	public void setIdPizza(int idPizza) {
		this.idPizza = idPizza;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	
	

}
