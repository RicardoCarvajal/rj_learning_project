package com.intelix.sofka.app.response;

import java.math.BigDecimal;

import lombok.Getter;

@Getter
public class Response {
	private String status;
	private BigDecimal amount;
	private BigDecimal balance;
	private String message;

	public static Response createResponse() {
		return new Response();
	}

	public Response setStatus(String status) {
		this.status = status;
		return this;
	}

	public Response setAmount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Response setBalance(BigDecimal balance) {
		this.balance = balance;
		return this;
	}

	public Response setMessage(String message) {
		this.message = message;
		return this;
	}

	public Response build() {
		return this;
	}

}
