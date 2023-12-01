package com.sofka.services.app.entity;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("cuentas")
public class Cuenta {

	@Id
	private String id;
	private BigDecimal saldo_global;
	private Cliente cliente;

}
