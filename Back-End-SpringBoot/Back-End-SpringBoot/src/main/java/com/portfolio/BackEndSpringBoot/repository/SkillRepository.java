package com.portfolio.BackEndSpringBoot.repository;

import com.portfolio.BackEndSpringBoot.model.Skill;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SkillRepository extends JpaRepository<Skill, Long> {
}
