package com.portfolio.BackEndSpringBoot.repository;

import com.portfolio.BackEndSpringBoot.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project, Long> {
}
