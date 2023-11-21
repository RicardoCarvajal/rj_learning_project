package com.intelix.sofka.app.response;

import com.intelix.sofka.app.documents.Account;

import lombok.Getter;

@Getter
public class Response {
	private String status;
	private Account account;
	private String message;

	public static Response createResponse() {
		return new Response();
	}

	public Response setStatus(String status) {
		this.status = status;
		return this;
	}

	public Response setAccount(Account account) {
		this.account = account;
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
