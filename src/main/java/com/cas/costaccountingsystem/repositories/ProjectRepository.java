package com.cas.costaccountingsystem.repositories;

import com.cas.costaccountingsystem.domains.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
