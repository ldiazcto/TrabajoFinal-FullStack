package com.portfolio.BackEndSpringBoot.repository;

import com.portfolio.BackEndSpringBoot.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
