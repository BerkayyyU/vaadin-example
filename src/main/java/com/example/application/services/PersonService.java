package com.example.application.services;

import com.example.application.models.Person;

import java.util.Set;

public interface PersonService {
    Set<Person> getList();
    Set<Person> getList(String filter);
    Person save(Person p);
}
