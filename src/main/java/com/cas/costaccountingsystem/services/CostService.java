package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.repositories.CostRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostService {
    @NonNull
    private CostRepository repository;
}
