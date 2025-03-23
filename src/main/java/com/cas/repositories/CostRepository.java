package com.cas.repositories;

import com.cas.costaccountingsystem.entities.Cost;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CostRepository extends JpaRepository<Cost, Long> {
}
