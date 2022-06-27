package com.portfolio.BackEndSpringBoot.login;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class LoginService {
    @Autowired
    private LoginRepo loginRepo;

    public boolean isUserEnabled(Login login) {
        boolean isUserEnabled = false;
        List<Login> usuarios = loginRepo.findByName(login.getName());
        if (!usuarios.isEmpty()) {
            Login usuario = usuarios.get(0);
            if (usuario.getPassword().equals(login.getPassword())){
                isUserEnabled = true;
            }
        }
        return isUserEnabled;
    }

}
