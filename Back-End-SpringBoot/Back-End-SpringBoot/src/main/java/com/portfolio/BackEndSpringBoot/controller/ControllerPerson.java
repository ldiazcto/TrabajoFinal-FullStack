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
