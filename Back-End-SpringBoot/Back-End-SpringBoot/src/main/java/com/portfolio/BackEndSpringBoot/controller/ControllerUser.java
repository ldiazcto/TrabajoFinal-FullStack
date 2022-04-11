package com.portfolio.BackEndSpringBoot.controller;

import com.portfolio.BackEndSpringBoot.model.User;
import com.portfolio.BackEndSpringBoot.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ControllerUser {

    @Autowired
    private IUserService userService;

    @PostMapping("/new/user")
    public void add_user(@RequestBody User user){
        userService.add_user(user);
    }
    // @RequestBody cuerpo de la solicitud, la persona en cuestion va avenir en el cuerpo de la solicitud
    //cuando un cliente se comunica econ una API lo ahce con un lenguaje en comun en este caso
    //un json

    @GetMapping("/see/user")
    @ResponseBody
    public List<User> get_user(){
        return userService.get_user();
    }

    @DeleteMapping("/delete/{id}")
    public void delete_user(@PathVariable Long id){
        userService.delete_user(id);
    }
    //REsponse body osea lo que devuelvas quiero que lo devuelvas en formato de un response body
    //es decri que lo devuelvas en el cuerpo de la respuesta

    @PutMapping("/edit/{id}")
    public void update_user(@PathVariable Long id, @RequestBody User user ){
        userService.delete_user(id);
        userService.add_user(user);
    }

    @GetMapping("/user/{id}")
    @ResponseBody
    public User getUserById(@PathVariable long id){
        return userService.find_user(id);
    }

}
