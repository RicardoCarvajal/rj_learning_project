package com.intelix.sofka.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intelix.sofka.app.entitys.Account;

public interface AccountRepository extends JpaRepository<Account, Long> {

}
