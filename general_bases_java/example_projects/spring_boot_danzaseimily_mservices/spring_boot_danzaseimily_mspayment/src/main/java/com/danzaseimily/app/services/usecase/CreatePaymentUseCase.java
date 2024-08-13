package com.danzaseimily.app.services.usecase;

import com.danzaseimily.app.services.models.Payment;
import com.danzaseimily.app.services.repositories.PaymentRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreatePaymentUseCase {
    private final PaymentRepository repository;
    public CreatePaymentUseCase(PaymentRepository repository) {
        this.repository = repository;
    }
    public Mono<Payment> createPayment(Payment payment) {
        return repository.save(payment);
    }
}
