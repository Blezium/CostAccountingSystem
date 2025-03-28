package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.domains.Account;
import com.cas.costaccountingsystem.domains.FullName;
import com.cas.costaccountingsystem.dto.FullAccountDto;
import com.cas.costaccountingsystem.mappers.AccountMapper;
import com.cas.costaccountingsystem.mappers.FullNameMapper;
import com.cas.costaccountingsystem.repositories.AccountRepository;
import com.cas.costaccountingsystem.request.AccountCreationRequest;
import com.cas.costaccountingsystem.request.AccountUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class AccountService {
    private final AccountRepository repository;
    private final FullNameMapper fullNameMapper;
    private final AccountMapper accountMapper;

    public FullAccountDto create(AccountCreationRequest request) {
        Account account = new Account();

        account.setNickname(request.getNickname());
        FullName fullName = fullNameMapper.toDomain(request.getFullName());
        account.setFullName(fullName);
        account.setPassword(request.getPassword());
        account.setEmail(request.getEmail());
        account.setType(request.getType());
        account.setInitializedAt(LocalDateTime.now());
        account.setUpdatedAt(request.getUpdatedAt());
        Account savedAccount = repository.save(account);

        return accountMapper.toDto(savedAccount);
    }

    public FullAccountDto update(AccountUpdateRequest request, Long id) {
        Account existingAccount = getById(id);

        setIfNotNull(request.getNickname(), existingAccount::setNickname);
        setIfNotNull(request.getFullName(), fullNameDto -> existingAccount.setFullName(fullNameMapper.toDomain(fullNameDto)));
        setIfNotNull(request.getPassword(), existingAccount::setPassword);
        setIfNotNull(request.getEmail(), existingAccount::setEmail);
        setIfNotNull(request.getType(), existingAccount::setType);
        existingAccount.setUpdatedAt(LocalDateTime.now());

        Account savedAccount = repository.save(existingAccount);
        return accountMapper.toDto(savedAccount);
    }

    public void deleteById(Long id) {
        repository.deleteById(id);
    }

    public List<Account> getByIds(List<Long> ids) {
        return repository.findAllById(ids);
    }

    public Account getById(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public static <V> void setIfNotNull(V value, Consumer<V> setter) {
        if (Objects.nonNull(value)) {
            setter.accept(value);
        }
    }
}
