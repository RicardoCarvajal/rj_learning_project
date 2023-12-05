package com.sofka.services.app.service.implementation;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.sofka.services.app.dto.AccountDto;
import com.sofka.services.app.dto.CustomerDto;
import com.sofka.services.app.dto.DepositDto;
import com.sofka.services.app.dto.TransactionDto;
import com.sofka.services.app.entity.Transaccion;
import com.sofka.services.app.repository.IAccountRepository;
import com.sofka.services.app.repository.ITransactionRepository;
import com.sofka.services.app.service.ITransactionService;
import com.sofka.services.app.service.utils.DepositType;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class TransactionService implements ITransactionService {

	@Value("${EPA.Deposito.Cajero}")
	private String COMDEP;

	@Value("${EPA.Deposito.OtraCuenta}")
	private String COMCUE;

	@Value("${EPA.Deposito.Sucursal}")
	private String COMSUC;

	private final ITransactionRepository transactionRepository;

	private final IAccountRepository accountReporitory;

	public TransactionService(ITransactionRepository transactionRepository, IAccountRepository accountReporitory) {
		this.transactionRepository = transactionRepository;
		this.accountReporitory = accountReporitory;
	}

	@Override
	public Flux<TransactionDto> findAll() {
		return transactionRepository.findAll().map(transaccion -> {
			return new TransactionDto(transaccion.getId(),
					new AccountDto(transaccion.getCuenta().getId(),
							new CustomerDto(transaccion.getCuenta().getCliente().getId(),
									transaccion.getCuenta().getCliente().getNombre()),
							transaccion.getCuenta().getSaldo_global()),
					transaccion.getMonto_transaccion(), transaccion.getSaldo_inicial(), transaccion.getSaldo_final(),
					transaccion.getCosto_transaccion(), transaccion.getTipo());
		});
	}

	@Override
	public Mono<DepositDto> proccesDeposit(String idAccount, DepositType type, BigDecimal amount) {

		return accountReporitory.findByid(idAccount).flatMap(c -> {

			return transactionRepository.save(new Transaccion(c, amount, c.getSaldo_global(),
					c.getSaldo_global().add(amount.subtract(typeTransaction(type))), typeTransaction(type),
					type.toString()));

		}).flatMap(t -> {
			t.getCuenta().setSaldo_global(t.getSaldo_final());
			return accountReporitory.save(t.getCuenta());
		}).map(c -> {
			return new DepositDto(c.getId(), amount, type.name());
		});

	}

	private BigDecimal typeTransaction(DepositType type) {
		BigDecimal cost = BigDecimal.ZERO;

		switch (type) {
		case CAJERO:
			cost = new BigDecimal(COMDEP);
			break;
		case SUCURSAL:
			cost = new BigDecimal(COMSUC);
			break;
		case OTRA_CUENTA:
			cost = new BigDecimal(COMCUE);
			break;
		}
		return cost;
	}

}
