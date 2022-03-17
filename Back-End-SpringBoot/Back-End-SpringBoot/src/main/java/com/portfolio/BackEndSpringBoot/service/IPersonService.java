package com.portfolio.BackEndSpringBoot.service;

import com.portfolio.BackEndSpringBoot.model.Person;

import java.util.List;

public interface IPersonService {

    public List<Person> see_person();

    public void create_person(Person per);

    public void delete_person(Long id);

    public Person find_person(Long id);

    public void edit_person(Long id);
}
