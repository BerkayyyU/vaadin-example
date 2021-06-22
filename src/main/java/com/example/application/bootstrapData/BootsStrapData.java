package com.example.application.bootstrapData;

import com.example.application.models.Person;
import com.example.application.services.PersonService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsStrapData implements CommandLineRunner {

    private final PersonService personService;

    public BootsStrapData(PersonService personService) {
        this.personService = personService;
    }

    @Override
    public void run(String... args) throws Exception {
        Person person = new Person();
        person.setName("Ali");
        person.setSurname("Duru");
        person.setPhoneNumber("123 345 567");

        personService.save(person);

        Person person2 = new Person();
        person2.setName("Aliye");
        person2.setSurname("Duru");
        person2.setPhoneNumber("123 123 123");

        personService.save(person2);


    }
}
