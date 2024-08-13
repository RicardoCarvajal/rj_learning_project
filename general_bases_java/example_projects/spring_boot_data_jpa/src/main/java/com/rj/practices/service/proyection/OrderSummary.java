package com.rj.practices.service.proyection;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public interface OrderSummary {
	
	Integer getIdOrder();
	String getCustomerName();
	LocalDateTime getOrderDate();
	BigDecimal getOrderTotal();
	String getPizzasNames();

}
