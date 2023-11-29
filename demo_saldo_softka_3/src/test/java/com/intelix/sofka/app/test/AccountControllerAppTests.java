package com.intelix.sofka.app.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

import java.math.BigDecimal;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.client.RestClientTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.MediaType;
import org.springframework.test.web.client.MockRestServiceServer;

import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.document.Customer;
import com.intelix.sofka.app.service.imp.AccountServiceImp;

@RestClientTest(AccountServiceImp.class)
public class AccountControllerAppTests {

	@Autowired
	private AccountServiceImp client;

	@Autowired
	private MockRestServiceServer mockServer;

	@MockBean
	private MongoTemplate mongoTemplate;

	@Before
	public void setUp() throws Exception {
		String result = """
				{
				    "status": "200",
				    "data": {
				        "id": "655faf7109067e242b242684",
				        "customer": {
				            "id": "V16772439",
				            "name": "Ricardo Carvajal",
				            "direction": "Bello Monte II, Calle Carabobo",
				            "type": 1,
				            "phone": "0414-4957298"
				        },
				        "balance": 15000,
				        "active": true
				    },
				    "message": "Cuenta encontrada"
				}
								""";

		mockServer.expect(requestTo("/api/account/655faf7109067e242b242684"))
				.andRespond(withSuccess(result, MediaType.APPLICATION_JSON));
	}

	@Test
	public void accountTest() {

		when(mongoTemplate.findById("655faf7109067e242b242684", Account.class))
				.thenReturn(Account.createAccount().id("655faf7109067e242b242684")
						.customer(Customer.createCustomer().id("V16772439").direction("Bello Monte II, Calle Carabobo")
								.name("Ricardo Carvajal").phone("0414-4957298").type(1).build())
						.balance(new BigDecimal(15000)).active(true).build());

		Account res = client.findById("655faf7109067e242b242684");

		assertThat(res).isNotNull();

	}

}
