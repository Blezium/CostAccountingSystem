package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.domains.Account;
import com.cas.costaccountingsystem.domains.Project;
import com.cas.costaccountingsystem.dto.ProjectDto;
import com.cas.costaccountingsystem.mappers.ProjectMapper;
import com.cas.costaccountingsystem.repositories.AccountRepository;
import com.cas.costaccountingsystem.repositories.ProjectRepository;
import com.cas.costaccountingsystem.request.ProjectCreationRequest;
import com.cas.costaccountingsystem.request.ProjectUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class ProjectService {
    private final ProjectRepository projectRepository;
    private final AccountRepository accountRepository;
    private final ProjectMapper projectMapper;

    public ProjectDto create(ProjectCreationRequest request) {
        Project project = new Project();

        project.setTitle(request.getTitle());
        project.setDescription(request.getDescription());
        project.setProjectType(request.getProjectType());
        project.setInitializedAt(LocalDateTime.now());
        project.setUpdatedAt(LocalDateTime.now());
        project.setCosts(new ArrayList<>());
        List<Account> accounts = accountRepository.findAllById(request.getAccountsIds());
        project.setAccounts(accounts);

        Project savedProject = projectRepository.save(project);
        return projectMapper.toDto(savedProject);
    }

    public ProjectDto update(ProjectUpdateRequest request, Long id) {
        Project existingProject = projectRepository.findById(id).orElse(null);
        List<Long> accountsIds = request.getAccountsIds();

        if (existingProject == null){
            return null;
        }

        setIfNotNull(request.getTitle(), existingProject::setTitle);
        setIfNotNull(request.getDescription(), existingProject::setDescription);
        setIfNotNull(request.getProjectType(), existingProject::setProjectType);
        existingProject.setUpdatedAt(LocalDateTime.now());

        if (accountsIds != null) {
            List<Account> accounts = accountRepository.findAllById(accountsIds);
            existingProject.setAccounts(accounts);
        }

        Project savedProject = projectRepository.save(existingProject);
        return projectMapper.toDto(savedProject);
    }

    public static <V> void setIfNotNull(V value, Consumer<V> setter) {
        if (Objects.nonNull(value)) {
            setter.accept(value);
        }
    }
}
