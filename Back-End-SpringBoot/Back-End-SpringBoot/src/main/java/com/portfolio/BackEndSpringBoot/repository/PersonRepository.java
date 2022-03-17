package com.portfolio.BackEndSpringBoot.repository;

import com.portfolio.BackEndSpringBoot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
