package EPA.Cuenta_Bancaria_Web.Servicio.Transaccion;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import EPA.Cuenta_Bancaria_Web.Modelo.Enum_Tipos_Deposito;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cliente_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Cuenta_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.DTO.M_Transaccion_DTO;
import EPA.Cuenta_Bancaria_Web.Modelo.Mongo.M_TransaccionMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_RepositorioCuentaMongo;
import EPA.Cuenta_Bancaria_Web.Repositorio.Mongo.I_Repositorio_TransaccionMongo;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class Transaccion_ImpMongo implements I_Transaccion {

	@Value("${EPA.Deposito.Cajero}")
	private String COMDEP;

	@Value("${EPA.Deposito.OtraCuenta}")
	private String COMCUE;

	@Value("${EPA.Deposito.Sucursal}")
	private String COMSUC;

	private final I_Repositorio_TransaccionMongo transaccion_repositorio;

	private final I_RepositorioCuentaMongo cuenta_repositorio;

	public Transaccion_ImpMongo(I_Repositorio_TransaccionMongo transaccion_repositorio,
			I_RepositorioCuentaMongo cuenta_repositorio) {
		this.transaccion_repositorio = transaccion_repositorio;
		this.cuenta_repositorio = cuenta_repositorio;
	}

	@Override
	public Flux<M_Transaccion_DTO> findAll() {
		return transaccion_repositorio.findAll().map(transaccion -> {
			return new M_Transaccion_DTO(transaccion.getId(),
					new M_Cuenta_DTO(transaccion.getCuenta().getId(),
							new M_Cliente_DTO(transaccion.getCuenta().getCliente().getId(),
									transaccion.getCuenta().getCliente().getNombre()),
							transaccion.getCuenta().getSaldo_Global()),
					transaccion.getMonto_transaccion(), transaccion.getSaldo_inicial(), transaccion.getSaldo_final(),
					transaccion.getCosto_tansaccion(), transaccion.getTipo());
		});
	}

	@Override
	public Mono<M_Transaccion_DTO> Procesar_Deposito(String id_Cuenta, Enum_Tipos_Deposito tipo, BigDecimal monto) {

		return cuenta_repositorio.findByid(id_Cuenta).flatMap(c -> {

			BigDecimal costo = BigDecimal.ZERO;

			switch (tipo) {
			case CAJERO:
				costo = new BigDecimal(COMDEP);
				break;
			case SUCURSAL:
				costo = new BigDecimal(COMSUC);
				break;
			case OTRA_CUENTA:
				costo = new BigDecimal(COMCUE);
				break;
			}

			BigDecimal bdSaldoActual = c.getSaldo_Global();
			BigDecimal bdSaldoNuevo = c.getSaldo_Global().add(monto.subtract(costo));

			M_TransaccionMongo transaccion = new M_TransaccionMongo(c, monto, bdSaldoActual, bdSaldoNuevo, costo,
					tipo.toString());

			c.setSaldo_Global(bdSaldoNuevo);

			cuenta_repositorio.save(c).subscribe();

			return transaccion_repositorio.save(transaccion).map(t -> {
				return new M_Transaccion_DTO(t.getId(),
						new M_Cuenta_DTO(t.getCuenta().getId(),
								new M_Cliente_DTO(t.getCuenta().getCliente().getId(),
										t.getCuenta().getCliente().getNombre()),
								t.getCuenta().getSaldo_Global()),
						t.getMonto_transaccion(), t.getSaldo_inicial(), t.getSaldo_final(), t.getCosto_tansaccion(),
						t.getTipo());
			});

		});

	}

}
