package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Person;
import com.portfolio.BackEndSpringBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService implements IPersonService {

    @Autowired
    public PersonRepository personRepo;

    @Override
    public List<Person> see_person() {
        return personRepo.findAll();
    }

    @Override
    public void create_person(Person per) {
        personRepo.save(per);
    }

    @Override
    public void delete_person(Long id) {
        personRepo.deleteById(id);
    }

    @Override
    public Person find_person(Long id) {
        return personRepo.findById(id).orElse(null);
    }

    @Override
    public void edit_person(Long id) {

    }
}
