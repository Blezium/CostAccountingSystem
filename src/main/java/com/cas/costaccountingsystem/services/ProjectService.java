package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.domains.Project;
import com.cas.costaccountingsystem.dto.ProjectDto;
import com.cas.costaccountingsystem.mappers.ProjectMapper;
import com.cas.costaccountingsystem.repositories.ProjectRepository;
import com.cas.costaccountingsystem.request.ProjectCreationRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository repository;
    private final ProjectMapper projectMapper;
    private final AccountService accountService;

    public ProjectDto create(ProjectCreationRequest request) {
        Project project = new Project();
        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setProjectType(request.getProjectType());
        project.setInitializedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        project.setCosts(new ArrayList<>());
        project.setAccounts(accountService.getByIds(request.getAccountsIds()));

        Project savedProject = repository.save(project);

        return projectMapper.toDto(savedProject);
    }
}
