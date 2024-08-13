package com.danzaseimily.app.services.handlers;

import com.danzaseimily.app.services.dtos.PaymentDto;
import com.danzaseimily.app.services.dtos.ResponseDto;
import com.danzaseimily.app.services.exceptions.ValidationsParamException;
import com.danzaseimily.app.services.models.Payment;
import com.danzaseimily.app.services.usecase.CreatePaymentUseCase;
import com.danzaseimily.app.services.usecase.GetAccountUseCase;
import com.danzaseimily.app.services.utils.ValidationsParameters;
import io.netty.handler.codec.http.HttpResponseStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import java.net.URI;

@Component
public class PaymentHandler {
    private final CreatePaymentUseCase createPayment;
    private final GetAccountUseCase getAccount;
    private final ValidationsParameters validator;

    public PaymentHandler(CreatePaymentUseCase createPayment, GetAccountUseCase getAccount, ValidationsParameters validator) {
        this.createPayment = createPayment;
        this.getAccount = getAccount;
        this.validator = validator;
    }

    public Mono<ServerResponse> create(ServerRequest request) {
        Mono<PaymentDto> paymentMono = request.bodyToMono(PaymentDto.class);
        return paymentMono.flatMap(pay -> {
            return validator.valid(pay).flatMap(payValidated -> getAccount.get(payValidated.getIdAccount()).flatMap(account -> {
                Payment payment = new Payment();
                payment.setAccount(account);
                payment.setAmount(payValidated.getAmount());
                return createPayment.createPayment(payment).flatMap(result -> ServerResponse.created(URI.create("/api/v1/payment/" + result.get_id())).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.CREATED.toString()).message("Pago creado con exito").data(result).build()));
            }).switchIfEmpty(ServerResponse.status(HttpResponseStatus.NOT_FOUND.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.NOT_FOUND.toString()).message("No existe la cuenta").build())));
        }).onErrorResume(ValidationsParamException.class, e -> {
            return ServerResponse.badRequest().contentType(MediaType.APPLICATION_JSON).bodyValue(e.getMessageResponse());
        }).onErrorResume(e -> {
            return ServerResponse.status(HttpResponseStatus.INTERNAL_SERVER_ERROR.code()).contentType(MediaType.APPLICATION_JSON).bodyValue(ResponseDto.builder().code(HttpResponseStatus.INTERNAL_SERVER_ERROR.toString()).message("Error de la aplicacion" + " " + e.getMessage()).build());
        });
    }
}
