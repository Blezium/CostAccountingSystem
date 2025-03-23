package com.cas.services;

import com.cas.repositories.CostRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CostService {
    @NonNull
    private CostRepository repository;
}
