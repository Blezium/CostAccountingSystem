package com.cas.repositories;

import com.cas.costaccountingsystem.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT first_name, last_name, account_type FROM Account LIMIT :accountsLimit", nativeQuery = true)
    List<Account> getAccounts(@Param("usersLimit") int accountsLimit);

    @Query(value = "SELECT COUNT(*) FROM Account", nativeQuery = true)
    double countAccounts();
}
