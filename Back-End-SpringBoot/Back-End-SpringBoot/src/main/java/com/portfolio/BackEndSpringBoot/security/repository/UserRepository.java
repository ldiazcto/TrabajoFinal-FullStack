package com.portfolio.BackEndSpringBoot.security.repository;

import java.util.Optional;

import com.portfolio.BackEndSpringBoot.security.entity.MainUser;
import com.portfolio.BackEndSpringBoot.security.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
    Optional<User> findByNameUser(String nameUser);
    boolean existsByNameUser(String NameUser);
}
