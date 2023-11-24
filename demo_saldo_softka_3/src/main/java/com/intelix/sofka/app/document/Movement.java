package com.intelix.sofka.app.document;

import java.math.BigDecimal;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("movements")
public class Movement {

	@Id
	private String id;

	private String idAccount;

	private BigDecimal amount;

	private BigDecimal commission;

	private String type;

	public Movement() {

	}

	public String getId() {
		return id;
	}

	public String getIdAccount() {
		return idAccount;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public BigDecimal getCommission() {
		return commission;
	}

	public String getType() {
		return type;
	}

	public void setId(String id) {
		this.id = id;
	}

	public void setIdAccount(String idAccount) {
		this.idAccount = idAccount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public void setCommission(BigDecimal commission) {
		this.commission = commission;
	}

	public void setType(String type) {
		this.type = type;
	}

	/* Builder */

	public static Movement createMovement() {
		return new Movement();
	}

	public Movement id(String id) {
		this.id = id;
		return this;
	}

	public Movement idAccount(String idAccount) {
		this.idAccount = idAccount;
		return this;
	}

	public Movement amount(BigDecimal amount) {
		this.amount = amount;
		return this;
	}

	public Movement commission(BigDecimal commission) {
		this.commission = commission;
		return this;
	}

	public Movement type(String type) {
		this.type = type;
		return this;
	}

}
