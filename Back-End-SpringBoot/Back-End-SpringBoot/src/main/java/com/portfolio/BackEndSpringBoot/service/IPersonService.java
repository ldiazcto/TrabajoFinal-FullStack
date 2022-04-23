package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Person;

import java.util.List;

public interface IPersonService {

    public List<Person> get_person();

    public void add_person(Person person);

    public void delete_person(Long id);

    public Person find_person(Long id);

    public void edit_person(Long id);

}
