package com.intelix.sofka.app.models;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class AcountNormal implements IAcount {

	private String IdName;
	private BigDecimal balance;
	private Integer daysCredits;
	private Integer acountType;

	@Override
	public BigDecimal getBalances() {
		return balance;
	}

	@Override
	public Integer getCreditsDays() {
		return daysCredits;
	}

}
