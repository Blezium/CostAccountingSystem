package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.repositories.CostRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostService {
    private CostRepository repository;
}
