package com.portfolio.BackEndSpringBoot.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {


    @GetMapping("/hola")
    public String decirHola(){
        return "Hola Mundo";
    }

}
