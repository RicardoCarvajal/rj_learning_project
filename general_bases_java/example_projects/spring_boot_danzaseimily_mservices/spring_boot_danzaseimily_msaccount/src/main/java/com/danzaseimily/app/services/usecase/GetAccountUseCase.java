package com.danzaseimily.app.services.usecase;

import com.danzaseimily.app.services.models.Account;
import com.danzaseimily.app.services.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class GetAccountUseCase {

    private final AccountRepository repository;

    public GetAccountUseCase(AccountRepository repository) {
        this.repository = repository;
    }

    public Mono<Account> get(String id) {
        return repository.findById(id);
    }
}
