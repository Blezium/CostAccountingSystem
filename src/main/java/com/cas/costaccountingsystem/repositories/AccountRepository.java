package com.cas.costaccountingsystem.repositories;

import com.cas.costaccountingsystem.domains.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
