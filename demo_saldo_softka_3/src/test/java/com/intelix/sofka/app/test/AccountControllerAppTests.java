package com.intelix.sofka.app.test;

import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.document.Customer;
import com.intelix.sofka.app.servicio.IAccountService;

@RestClientTest(IAccountService.class)
public class AccountControllerAppTests {

	@Autowired
	private IAccountService client;

	@MockBean
	private MongoTemplate mongoTemplate;

	@Test
	public void accountTest() {

		when(mongoTemplate.findById("655faf7109067e242b242684", Account.class))
				.thenReturn(Account.createAccount().id("655faf7109067e242b242684")
						.customer(Customer.createCustomer().id("V16772439").direction("Bello Monte II, Calle Carabobo")
								.name("Ricardo Carvajal").phone("0414-4957298").type(1).build())
						.balance(new BigDecimal(15000)).active(true).build());

		Account res = client.findById("655faf7109067e242b242684");

		assertTrue(res.getActive());

		Mockito.verify(mongoTemplate).findById("655faf7109067e242b242684", Account.class);

	}

}
