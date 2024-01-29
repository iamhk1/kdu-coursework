package org.example.service;


import org.example.model.Person;
import org.example.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class StartUpDataAddition implements CommandLineRunner {


    PersonRepository personRepository;
    PasswordEncoder passwordEncoder;
    @Autowired
    public StartUpDataAddition(PersonRepository personRepository,PasswordEncoder passwordEncoder)
    {
        this.personRepository=personRepository;
        this.passwordEncoder=passwordEncoder;
    }

    @Override
    public void run(String... args) throws Exception {
        personRepository.addPerson(new Person("Harsh", "harsh", passwordEncoder.encode("hk123"), "ROLE_ADMIN"));
        personRepository.addPerson(new Person("Mayank", "mayank", passwordEncoder.encode("mk123"), "ROLE_BASIC"));
    }
}
