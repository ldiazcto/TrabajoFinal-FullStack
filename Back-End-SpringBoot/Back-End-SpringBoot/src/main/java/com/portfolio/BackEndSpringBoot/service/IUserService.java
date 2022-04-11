package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.User;

import java.util.List;

public interface IUserService {

    public List<User> get_user();

    public void add_user(User user);

    public void delete_user(Long id);

    public User find_user(Long id);

    public void edit_user(Long id);

    User get_userById(long id);
}
