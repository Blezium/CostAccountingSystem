package com.cas.costaccountingsystem.request;

import com.cas.costaccountingsystem.domains.ProjectType;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import java.util.List;

@Setter
@Getter
public class ProjectCreationRequest {
    @NotEmpty(message = "Title can not be empty")
    private String title;

    private String description;

    private ProjectType projectType;

    private List<Long> accountsIds;
}
