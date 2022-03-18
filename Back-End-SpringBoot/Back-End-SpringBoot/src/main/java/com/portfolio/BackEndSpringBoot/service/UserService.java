package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.User;
import com.portfolio.BackEndSpringBoot.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    public UserRepository userRepo;

    @Override
    public List<User> get_user() {
        return userRepo.findAll();
    }

    @Override
    public void add_user(User user) {
        userRepo.save(user);
    }

    @Override
    public void delete_user(Long id) {
        userRepo.deleteById(id);
    }

    @Override
    public User find_user(Long id) {
        return userRepo.findById(id).orElse(null);
    }

    @Override
    public void edit_user(Long id) {

    }
}
