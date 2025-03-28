package com.cas.costaccountingsystem.services;

import com.cas.costaccountingsystem.domains.Cost;
import com.cas.costaccountingsystem.domains.Project;
import com.cas.costaccountingsystem.dto.CostDto;
import com.cas.costaccountingsystem.mappers.CostMapper;
import com.cas.costaccountingsystem.repositories.CostRepository;
import com.cas.costaccountingsystem.repositories.ProjectRepository;
import com.cas.costaccountingsystem.request.CostCreationRequest;
import com.cas.costaccountingsystem.request.CostUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.function.Consumer;

@Service
@RequiredArgsConstructor
public class CostService {
    private final CostRepository costRepository;
    private final ProjectRepository projectRepository;
    private final CostMapper costMapper;

    public CostDto create(CostCreationRequest request) {
        Cost cost = new Cost();
        Long projectId = request.getProjectId();

        if (projectId == null) {
            return null;
        }

        setIfNotNull(request.getPrice(), cost::setPrice);
        setIfNotNull(request.getCurrency(), cost::setCurrency);
        setIfNotNull(request.getDescription(), cost::setDescription);
        cost.setInitializedAt(LocalDateTime.now());
        cost.setUpdatedAt(LocalDateTime.now());
        Project project = projectRepository.findById(projectId).orElseThrow();
        cost.setProject(project);

        Cost savedCost = costRepository.save(cost);
        return costMapper.toDto(savedCost);
    }

    public CostDto update(CostUpdateRequest request, Long id) {
        Cost existingCost = costRepository.findById(id).orElseThrow();

        setIfNotNull(request.getPrice(), existingCost::setPrice);
        setIfNotNull(request.getCurrency(), existingCost::setCurrency);
        setIfNotNull(request.getDescription(), existingCost::setDescription);

        Cost savedCost = costRepository.save(existingCost);
        return costMapper.toDto(savedCost);
    }

    public static <V> void setIfNotNull(V value, Consumer<V> setter) {
        if (Objects.nonNull(value)) {
            setter.accept(value);
        }
    }
}
