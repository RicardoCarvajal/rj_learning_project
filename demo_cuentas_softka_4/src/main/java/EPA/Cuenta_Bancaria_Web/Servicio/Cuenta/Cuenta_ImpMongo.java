package EPA.Cuenta_Bancaria_Web.Servicio.Cuenta;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cliente_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_ClienteMongo;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_CuentaMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_RepositorioCuentaMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service()
public class Cuenta_ImpMongo implements I_Cuenta {

	@Autowired
	I_RepositorioCuentaMongo repositorio_Cuenta;

	@Override
	public Mono<M_Cuenta_DTO> crear_Cuenta(M_Cuenta_DTO p_Cuenta_DTO) {

		M_CuentaMongo cuenta = new M_CuentaMongo(p_Cuenta_DTO.getId(),
				new M_ClienteMongo(p_Cuenta_DTO.getCliente().getId(), p_Cuenta_DTO.getCliente().getNombre()),
				p_Cuenta_DTO.getSaldo_Global());

		Mono<M_CuentaMongo> cuenta_Creada = repositorio_Cuenta.save(cuenta);

		return cuenta_Creada.map(c -> {
			return new M_Cuenta_DTO(c.getId(), new M_Cliente_DTO(c.getCliente().getId(), c.getCliente().getNombre()),
					c.getSaldo_Global());
		});

	}

	@Override
	public Flux<M_Cuenta_DTO> findAll() {

		return repositorio_Cuenta.findAll().map(c -> {

			return new M_Cuenta_DTO(c.getId(), new M_Cliente_DTO(c.getCliente().getId(), c.getCliente().getNombre()),
					c.getSaldo_Global());

		});

	}
}
