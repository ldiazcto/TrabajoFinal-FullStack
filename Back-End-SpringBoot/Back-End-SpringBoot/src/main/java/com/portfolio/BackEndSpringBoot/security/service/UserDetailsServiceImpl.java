package com.portfolio.BackEndSpringBoot.security.service;

import com.portfolio.BackEndSpringBoot.security.entity.MainUser;
import com.portfolio.BackEndSpringBoot.security.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


@Service
public class UserDetailsServiceImpl implements UserDetailsService{
    @Autowired
    UserService userService;

    @Override
    public UserDetails loadUserByUsername(String nameUser) throws UsernameNotFoundException {
        User user = userService.getByNameUser(nameUser).get();

        return MainUser.build(user);
    }

}
