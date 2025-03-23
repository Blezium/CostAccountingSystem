package com.cas.costaccountingsystem.repositories;

import com.cas.costaccountingsystem.domains.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, Long> {
}
