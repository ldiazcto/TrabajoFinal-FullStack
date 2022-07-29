package com.portfolio.BackEndSpringBoot.controller;

import com.portfolio.BackEndSpringBoot.model.Person;
import com.portfolio.BackEndSpringBoot.service.IPersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = {"https://portfolio-lu.web.app"})
@RestController
@RequestMapping("/home")
public class ControllerPerson {

    @Autowired
    private IPersonService personService;

//    @PostMapping("/new/person")
//    public void add_user(@RequestBody Person person){
//        personService.add_person(person);
//    }
//    // @RequestBody cuerpo de la solicitud, la persona en cuestion va avenir en el cuerpo de la solicitud
//    //cuando un cliente se comunica econ una API lo ahce con un lenguaje en comun en este caso
//    //un json
//
//    @GetMapping("/see/person")
//    @ResponseBody
//    public List<Person> get_person(){
//        return personService.get_person();
//    }
//
//    @DeleteMapping("/delete/{id}")
//    public void delete_person(@PathVariable Long id){
//        personService.delete_person(id);
//    }
//    //REsponse body osea lo que devuelvas quiero que lo devuelvas en formato de un response body
//    //es decri que lo devuelvas en el cuerpo de la respuesta
//
//    @PutMapping("/edit/{id}")
//    public void update_person(@PathVariable Long id, @RequestBody Person person){
//        personService.delete_person(id);
//        personService.add_person(person);
//    }
//
//    @GetMapping("/person/{id}")
//    @ResponseBody
//    public Person getpersonById(@PathVariable long id){
//        return personService.find_person(id);
//    }
//


    @GetMapping
    public ResponseEntity<List<Person>> getAllPersonas(){
        List<Person> personas = personService.get_person();
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Person> addPersona(@RequestBody Person person) {
        Person newPerson = personService.add_person(person);
        return new ResponseEntity<>(newPerson, HttpStatus.CREATED);
    }

    @PutMapping("/edit")
    public ResponseEntity<Person> editPersona(@RequestBody Person person) {
        Person editPerson = personService.edit_person(person);
        return new ResponseEntity<>(editPerson, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable("id") Long id) {
        personService.delete_person(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
