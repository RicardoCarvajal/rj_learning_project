package com.intelix.sofka.app.response;

import java.math.BigDecimal;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class ResponseLombok {

	private String status;
	private BigDecimal amount;
	private BigDecimal balance;
	private String message;

}
