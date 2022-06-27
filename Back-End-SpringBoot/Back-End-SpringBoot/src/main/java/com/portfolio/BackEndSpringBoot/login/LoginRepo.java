package com.portfolio.BackEndSpringBoot.login;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginRepo extends JpaRepository<Login, Long> {
    List<Login> findByName(String name);
}
