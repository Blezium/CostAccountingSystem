package com.cas.costaccountingsystem.dto;

import com.cas.costaccountingsystem.domains.ProjectType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class ProjectDto {
    private Long id;

    private String title;

    private String description;

    private LocalDateTime initializedAt;

    private LocalDateTime updatedAt;

    private ProjectType projectType;

    private List<FullAccountDto> accounts;

    private List<CostDto> costs;
}
