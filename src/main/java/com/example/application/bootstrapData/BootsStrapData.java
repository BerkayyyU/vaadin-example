package com.example.application.bootstrapData;

import com.example.application.models.Person;
import com.example.application.models.SystemUser;
import com.example.application.services.PersonService;
import com.example.application.services.SystemUserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootsStrapData implements CommandLineRunner {

    private final PersonService personService;
    private final SystemUserService systemUserService;

    public BootsStrapData(PersonService personService, SystemUserService systemUserService) {
        this.personService = personService;
        this.systemUserService = systemUserService;
    }

    @Override
    public void run(String... args) throws Exception {

        SystemUser systemUser = new SystemUser();
        systemUser.setEmail("berkayulguel@gmail.com");
        systemUser.setPassword("123");
        systemUserService.save(systemUser);

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
