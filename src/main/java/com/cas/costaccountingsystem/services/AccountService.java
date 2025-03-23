package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.repositories.AccountRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AccountService {
    @NonNull
    private AccountRepository repository;
}
