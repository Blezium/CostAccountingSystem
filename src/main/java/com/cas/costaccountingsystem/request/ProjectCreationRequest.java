package com.cas.costaccountingsystem.request;

import com.cas.costaccountingsystem.domains.ProjectType;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
public class ProjectCreationRequest {
    private String title;

    private String description;

    private LocalDateTime initializedAt;

    private LocalDateTime updatedAt;

    private ProjectType projectType;

    private List<Long> accountsIds;

    private List<Long> costsIds;
}
