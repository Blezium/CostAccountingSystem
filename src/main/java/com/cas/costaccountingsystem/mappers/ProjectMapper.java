package com.cas.costaccountingsystem.mappers;

import com.cas.costaccountingsystem.domains.Project;
import com.cas.costaccountingsystem.dto.ProjectDto;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProjectMapper extends BaseMapper<Project, ProjectDto> {
}
