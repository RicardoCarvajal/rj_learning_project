package com.danzaseimily.app.services.usecase;

import com.danzaseimily.app.services.models.Account;
import com.danzaseimily.app.services.repositories.AccountRepository;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
public class CreateAccoutnUseCase {

    private final AccountRepository repository;

    public CreateAccoutnUseCase(AccountRepository repository) {
        this.repository = repository;
    }

    public Mono<Account> create(Account account) {
        return repository.save(account);
    }
}
