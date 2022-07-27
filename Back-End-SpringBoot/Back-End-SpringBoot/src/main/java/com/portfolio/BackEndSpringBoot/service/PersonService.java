package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Person;
import com.portfolio.BackEndSpringBoot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonService implements IPersonService {

    @Autowired
    public PersonRepository personRepo;

    @Override
    public List<Person> get_person() {
        return personRepo.findAll();
    }

    @Override
    public Person add_person(Person person) {
        return personRepo.save(person);
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
    public Person edit_person(Person person) {
        return personRepo.save(person);
    }

}
