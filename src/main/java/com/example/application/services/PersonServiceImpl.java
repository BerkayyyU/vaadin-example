package com.example.application.services;

import com.example.application.models.Person;
import com.example.application.repositories.PersonRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class PersonServiceImpl implements PersonService{

    private final PersonRepository personRepository;

    public PersonServiceImpl(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public Set<Person> getList() {
        Set<Person> personSet = new HashSet<>();
        personRepository.findAll().iterator().forEachRemaining(personSet::add); // Repodaki tüm personları listeliyor
        return personSet;
    }

    @Override
    public Set<Person> getList(String filter) {
        Set<Person> personSet = new HashSet<>();
        personRepository.findByNameContainingOrSurnameContaining(filter,filter).iterator().forEachRemaining(personSet::add); // Repodaki tüm personları listeliyor
        return personSet;
    }

    @Override
    public Person save(Person p) {
        return personRepository.save(p); //Repoya person ekliyor
    }

    @Override
    public void delete(Person p) {
        personRepository.delete(p);
    }
}
