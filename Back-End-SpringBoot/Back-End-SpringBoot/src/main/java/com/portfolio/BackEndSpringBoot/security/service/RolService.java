package com.portfolio.BackEndSpringBoot.security.service;

import java.util.Optional;
import javax.transaction.Transactional;

import com.portfolio.BackEndSpringBoot.security.entity.Rol;
import com.portfolio.BackEndSpringBoot.security.enums.RolName;
import com.portfolio.BackEndSpringBoot.security.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Transactional
public class RolService {
    @Autowired
    RolRepository rolRepository;

    public Optional<Rol> getByRoleName(RolName roleName) {
        return rolRepository.findByRolName(roleName);
    }

    public void save(Rol rol) {
        rolRepository.save(rol);
    }
}
