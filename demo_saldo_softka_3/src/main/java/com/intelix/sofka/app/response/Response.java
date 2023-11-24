package com.intelix.sofka.app.response;

public class Response {

	private String status;
	private Object data;
	private String message;

	public Response() {

	}

	/* Patron builder */

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public static Response createResponse() {
		return new Response();
	}

	public Response status(String status) {
		this.status = status;
		return this;
	}

	public Response data(Object data) {
		this.data = data;
		return this;
	}

	public Response message(String message) {
		this.message = message;
		return this;
	}

	public Response build() {
		return this;
	}

}
