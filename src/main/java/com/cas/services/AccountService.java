package com.cas.services;

import com.cas.costaccountingsystem.entities.Account;
import com.cas.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    @Autowired
    private AccountRepository repository;

    double getAccountsAmount() {
        return repository.countAccounts();
    }

    List<Account> getAccounts(int accountsLimit) {
        return repository.getAccounts(accountsLimit);
    }
}
