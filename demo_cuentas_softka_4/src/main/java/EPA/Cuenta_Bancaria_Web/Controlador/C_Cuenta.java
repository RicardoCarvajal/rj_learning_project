package EPA.Cuenta_Bancaria_Web.Controlador;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Servicio.Cuenta.I_Cuenta;
import jakarta.validation.Valid;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Validated
@RestController
@RequestMapping("Cuentas")
public class C_Cuenta {

	private final I_Cuenta cuenta;

	public C_Cuenta(I_Cuenta cuenta) {
		this.cuenta = cuenta;
	}

	@PostMapping(value = "/Crear")
	public Mono<M_Cuenta_DTO> Crear_Cuenta(@Valid @RequestBody M_Cuenta_DTO p_cuenta) {

		return cuenta.crear_Cuenta(p_cuenta);

	}

	@GetMapping(value = "/listar_cuentas")
	public Flux<M_Cuenta_DTO> listar_cuentas() {
		return cuenta.findAll();
	}

}
