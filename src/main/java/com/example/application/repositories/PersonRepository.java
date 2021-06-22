package com.example.application.repositories;

import com.example.application.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PersonRepository extends CrudRepository<Person,Long>, JpaRepository<Person,Long> {
    List<Person> findByNameContainingOrSurnameContaining(String name, String surname);
}
