package com.cas.costaccountingsystem.repositories;

import com.cas.costaccountingsystem.entities.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface AccountRepository extends JpaRepository<Account, Long> {
    @Query(value = "SELECT first_name, last_name, account_type FROM Account LIMIT :usersLimit", nativeQuery = true)
    String findUsers(@Param("usersLimit") double usersLimit);

    @Query(value = "SELECT COUNT(*) FROM Account", nativeQuery = true)
    double countAccounts();
}
