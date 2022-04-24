package com.portfolio.BackEndSpringBoot.security.controller;

import java.util.HashSet;
import java.util.Set;
import javax.validation.Valid;
import com.portfolio.BackEndSpringBoot.security.dto.JwtDto;
import com.portfolio.BackEndSpringBoot.security.dto.LoginUser;
import com.portfolio.BackEndSpringBoot.security.dto.Message;
import com.portfolio.BackEndSpringBoot.security.dto.NewUser;
import com.portfolio.BackEndSpringBoot.security.entity.Rol;
import com.portfolio.BackEndSpringBoot.security.entity.User;
import com.portfolio.BackEndSpringBoot.security.enums.RolName;
import com.portfolio.BackEndSpringBoot.security.jwt.JwtProvider;
import com.portfolio.BackEndSpringBoot.security.service.RolService;
import com.portfolio.BackEndSpringBoot.security.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@CrossOrigin(origins = "*")
public class AuthController {
    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    UserService userService;

    @Autowired
    RolService roleService;

    @Autowired
    JwtProvider jwtProvider;

    @PostMapping("/new")
    public ResponseEntity<?> neww(@Valid @RequestBody NewUser newUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("misplaced fields"), HttpStatus.BAD_REQUEST);

        if (userService.existsByNameUser(newUser.getNameUser()))
            return new ResponseEntity(new Message("existing user"), HttpStatus.BAD_REQUEST);

        User user =
                new User(newUser.getName(), newUser.getNameUser(), passwordEncoder.encode(newUser.getPassword()));

        Set<Rol> roles = new HashSet<>();
        roles.add(roleService.getByRoleName(RolName.ROLE_USER).get());
        if (newUser.getRoles().contains("admin"))
            roles.add(roleService.getByRoleName(RolName.ROLE_ADMIN).get());

        user.setRol(roles);
        userService.save(user);

        return new ResponseEntity(new Message("saved user"), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<JwtDto> login(@Valid @RequestBody LoginUser loginUser, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return new ResponseEntity(new Message("misplaced fields"), HttpStatus.BAD_REQUEST);

        Authentication authentication =
                authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(loginUser.getNameUser(), loginUser.getPassword()));

        SecurityContextHolder.getContext().setAuthentication(authentication);
        String jwt = jwtProvider.generateToken(authentication);
        UserDetails userDetails = (UserDetails) authentication.getPrincipal();
        JwtDto jwtDto = new JwtDto(jwt, userDetails.getUsername(), userDetails.getAuthorities());

        return new ResponseEntity(jwtDto, HttpStatus.OK);
    }

}