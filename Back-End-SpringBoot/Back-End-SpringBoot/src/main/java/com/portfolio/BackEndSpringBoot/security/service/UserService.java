package com.portfolio.BackEndSpringBoot.security.service;

import java.util.Optional;
import javax.transaction.Transactional;

import com.portfolio.BackEndSpringBoot.security.entity.User;
import com.portfolio.BackEndSpringBoot.security.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class UserService {
    @Autowired
    UserRepository userRepository;

    public Optional<User> getByNameUser(String nameUser) {
        return userRepository.findByNameUser(nameUser);
    }

    public boolean existsByNameUser(String nameUser) {
        return userRepository.existsByNameUser(nameUser);
    }

    public void save(User user) {
        userRepository.save(user);
    }
}
