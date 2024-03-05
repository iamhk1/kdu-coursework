package org.example.service;


import org.example.model.Person;
import org.example.repo.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {


    PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository){
        this.personRepository=personRepository;
    }
    public void addPerson(Person person){
        personRepository.addPerson(person);
    }

    public Person getPersonById(int id){
        return personRepository.getPersonByIdx(id);
    }

    public String getRoleById(int id){
        return personRepository.getRoleByPersonIdx(id);
    }

    public Person getPersonUsername(String name){
        for(Person p : personRepository.getAllPersons()){
            if(p.getUsername().equals(name)){
                return p;
            }
        }
        return null;
    }
}
