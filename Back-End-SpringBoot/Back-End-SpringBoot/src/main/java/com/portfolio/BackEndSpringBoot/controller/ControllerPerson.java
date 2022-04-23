package com.portfolio.BackEndSpringBoot.controller;

import com.portfolio.BackEndSpringBoot.model.Person;
import com.portfolio.BackEndSpringBoot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = {"http://localhost:4200/"})
public class ControllerPerson {

    @Autowired
    private IPersonService personService;

    @PostMapping("/new/person")
    public void add_user(@RequestBody Person person){
        personService.add_person(person);
    }
    // @RequestBody cuerpo de la solicitud, la persona en cuestion va avenir en el cuerpo de la solicitud
    //cuando un cliente se comunica econ una API lo ahce con un lenguaje en comun en este caso
    //un json

    @GetMapping("/see/person")
    @ResponseBody
    public List<Person> get_person(){
        return personService.get_person();
    }

    @DeleteMapping("/delete/{id}")
    public void delete_person(@PathVariable Long id){
        personService.delete_person(id);
    }
    //REsponse body osea lo que devuelvas quiero que lo devuelvas en formato de un response body
    //es decri que lo devuelvas en el cuerpo de la respuesta

    @PutMapping("/edit/{id}")
    public void update_person(@PathVariable Long id, @RequestBody Person person){
        personService.delete_person(id);
        personService.add_person(person);
    }

    @GetMapping("/person/{id}")
    @ResponseBody
    public Person getpersonById(@PathVariable long id){
        return personService.find_person(id);
    }

}
