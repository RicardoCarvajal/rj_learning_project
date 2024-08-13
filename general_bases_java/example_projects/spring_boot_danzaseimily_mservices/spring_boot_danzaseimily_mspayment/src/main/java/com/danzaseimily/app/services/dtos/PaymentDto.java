package com.danzaseimily.app.services.dtos;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;


public class PaymentDto {

    @NotNull
    @NotEmpty
    private String idAccount;

    @NotNull
    @Min(1)
    private BigDecimal amount;


    public PaymentDto() {

    }

    public String getIdAccount() {
        return idAccount;
    }

    public void setIdAccount(String idAccount) {
        this.idAccount = idAccount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

}
