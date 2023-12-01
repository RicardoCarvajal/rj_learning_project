package com.sofka.services.app.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerDto {
	@NotNull(message = "[CLIENTE] [id] Campo Requerido: Id.")
	private String id;

	@NotNull(message = "[CLIENTE] [nombre] Campo Requerido: Id.")
	private String name;

}
