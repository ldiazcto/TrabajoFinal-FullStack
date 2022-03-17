package com.portfolio.BackEndSpringBoot.controller;

import com.portfolio.BackEndSpringBoot.model.Person;
import com.portfolio.BackEndSpringBoot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerPerson {

    @Autowired
    private IPersonService personService;

    @PostMapping("/new/person")
    public void agregarPersona(@RequestBody Person pers){
        personService.create_person(pers);
    }
    // @RequestBody cuerpo de la solicitud, la persona en cuestion va avenir en el cuerpo de la solicitud
    //cuando un cliente se comunica econ una API lo ahce con un lenguaje en comun en este caso
    //un json


    @GetMapping("/see/person")
    @ResponseBody
    public List<Person> verPersonas(){
        return personService.see_person();
    }

    @DeleteMapping("/delete/{id}")
    public void borrarPersona(@PathVariable Long id){
        personService.delete_person(id);
    }
    //REsponse body osea lo que devuelvas quiero que lo devuelvas en formato de un response body
    //es decri que lo devuelvas en el cuerpo de la respuesta

    @PutMapping("/edit/{id}")
    public void editarPersona(@PathVariable Long id, @RequestBody Person pers ){
        personService.delete_person(id);
        personService.create_person(pers);
    }


}
