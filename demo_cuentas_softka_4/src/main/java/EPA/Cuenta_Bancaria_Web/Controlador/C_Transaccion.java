package EPA.Cuenta_Bancaria_Web.Controlador;

import java.math.BigDecimal;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EPA.Cuenta_Bancaria_Web.Modelo.Enum_Tipos_Deposito;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Transaccion_DTO;
import EPA.Cuenta_Bancaria_Web.Servicio.Transaccion.I_Transaccion;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("Transacciones")
public class C_Transaccion {

	private final I_Transaccion transaccion;

	public C_Transaccion(I_Transaccion transaccion) {
		this.transaccion = transaccion;
	}

	@GetMapping(value = "/listar_transacciones")
	public Flux<M_Transaccion_DTO> listar_transacciones() {
		return transaccion.findAll();
	}

	@PostMapping(value = "/Crear/Deposito/Cajero/{id_Cuenta}/{monto}")
	public Mono<M_Transaccion_DTO> Procesar_Deposito_Cajero(@PathVariable String id_Cuenta,
			@PathVariable BigDecimal monto) {

		return transaccion.Procesar_Deposito(id_Cuenta, Enum_Tipos_Deposito.CAJERO, monto);
	}

	@PostMapping(value = "/Crear/Deposito/Sucursal/{id_Cuenta}/{monto}")
	public Mono<M_Transaccion_DTO> Procesar_Deposito_Sucursal(@PathVariable String id_Cuenta,
			@PathVariable BigDecimal monto) {
		return transaccion.Procesar_Deposito(id_Cuenta, Enum_Tipos_Deposito.SUCURSAL, monto);

	}

	@PostMapping(value = "/Crear/Deposito/OtraCuenta/{id_Cuenta}/{monto}")
	public Mono<M_Transaccion_DTO> Procesar_Deposito_OtraCuenta(@PathVariable String id_Cuenta,
			@PathVariable BigDecimal monto) {
		return transaccion.Procesar_Deposito(id_Cuenta, Enum_Tipos_Deposito.OTRA_CUENTA, monto);

	}

}
