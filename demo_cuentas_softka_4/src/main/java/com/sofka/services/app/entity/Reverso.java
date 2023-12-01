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
@Document("reversos")
public class Reverso {
	private String id;
	private BigDecimal monto_reverso;
	private String id_cuenta;

}
