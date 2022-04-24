package com.portfolio.BackEndSpringBoot.security.repository;

import java.util.Optional;

import com.portfolio.BackEndSpringBoot.security.entity.Rol;
import com.portfolio.BackEndSpringBoot.security.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolRepository extends JpaRepository<Rol, Integer> {
    Optional<Rol> findByRolName(RolName rolName);
}