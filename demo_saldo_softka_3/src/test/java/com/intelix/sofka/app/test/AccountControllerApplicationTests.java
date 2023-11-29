package com.intelix.sofka.app.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.intelix.sofka.app.controller.AccountController;
import com.intelix.sofka.app.document.Account;
import com.intelix.sofka.app.document.Customer;
import com.intelix.sofka.app.servicio.IAccountService;

@WebMvcTest(AccountController.class)
class AccountControllerApplicationTests {

	@MockBean
	private IAccountService iAccountService;

	@Autowired
	private MockMvc mockMvc;

	@Test
	public void accountControllerTest() throws Exception {

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

		when(iAccountService.findById("655faf7109067e242b242684"))
				.thenReturn(Account.createAccount().id("655faf7109067e242b242684")
						.customer(Customer.createCustomer().id("V16772439").direction("Bello Monte II, Calle Carabobo")
								.name("Ricardo Carvajal").phone("0414-4957298").type(1).build())
						.balance(new BigDecimal(15000)).active(true).build());

		mockMvc.perform(get("/api/account/655faf7109067e242b242684")).andExpect(status().isOk())
				.andExpect(content().json(result));

	}

}
