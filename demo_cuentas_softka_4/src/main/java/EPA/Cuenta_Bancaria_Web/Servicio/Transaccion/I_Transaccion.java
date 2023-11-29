package EPA.Cuenta_Bancaria_Web.Servicio.Transaccion;

import java.math.BigDecimal;

import EPA.Cuenta_Bancaria_Web.Modelo.Enum_Tipos_Deposito;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Transaccion_DTO;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface I_Transaccion {

	Mono<M_Transaccion_DTO> Procesar_Deposito(String id_Cuenta, Enum_Tipos_Deposito tipo, BigDecimal monto);

	Flux<M_Transaccion_DTO> findAll();
}
