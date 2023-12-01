package com.sofka.services.app.entity;

import java.math.BigDecimal;

import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Document("transacciones")
public class Transaccion {
	private String id;
	private BigDecimal monto_transaccion;
	private BigDecimal saldo_inicial;
	private BigDecimal saldo_final;
	private BigDecimal costo_transaccion;
	private String tipo;
	private Cuenta cuenta;

	public Transaccion(Cuenta cuenta, BigDecimal monto_transaccion, BigDecimal saldo_inicial, BigDecimal saldo_final,
			BigDecimal costo_tansaccion, String tipo) {
		this.cuenta = cuenta;
		this.monto_transaccion = monto_transaccion;
		this.saldo_inicial = saldo_inicial;
		this.saldo_final = saldo_final;
		this.costo_transaccion = costo_tansaccion;
		this.tipo = tipo;
	}

}
