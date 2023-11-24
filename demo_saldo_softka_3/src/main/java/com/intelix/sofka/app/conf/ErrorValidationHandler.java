package com.intelix.sofka.app.conf;

import java.util.ArrayList;
import java.util.List;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.intelix.sofka.app.response.Response;

@RestControllerAdvice
public class ErrorValidationHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Response> handleValidationException(MethodArgumentNotValidException ex) {
		List<String> errors = new ArrayList<>();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.add(fieldError.getDefaultMessage());
		}
		for (ObjectError globalError : ex.getBindingResult().getGlobalErrors()) {
			errors.add(globalError.getDefaultMessage());
		}

		return ResponseEntity.badRequest()
				.body(Response.createResponse().status("400").data(errors).message("Ups!! algo salio mal").build());
	}

	@ExceptionHandler(BindException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Response> handleBindException(BindException ex) {
		List<String> errors = new ArrayList<>();
		for (FieldError fieldError : ex.getBindingResult().getFieldErrors()) {
			errors.add(fieldError.getDefaultMessage());
		}
		for (ObjectError globalError : ex.getBindingResult().getGlobalErrors()) {
			errors.add(globalError.getDefaultMessage());
		}

		return ResponseEntity.badRequest()
				.body(Response.createResponse().status("400").data(errors).message("Ups!! algo salio mal").build());
	}

	@ExceptionHandler(DataIntegrityViolationException.class)
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ResponseEntity<Response> handleIntegrityException(DataIntegrityViolationException ex) {

		return ResponseEntity.badRequest().body(
				Response.createResponse().status("500").data(ex.getMessage()).message("Ups!! algo salio mal").build());
	}

}