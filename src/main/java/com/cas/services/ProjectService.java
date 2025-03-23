package com.cas.services;

import com.cas.repositories.ProjectRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectService {
    @NonNull
    private ProjectRepository repository;
}
