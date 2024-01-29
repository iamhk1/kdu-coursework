package org.example.repo;

import org.example.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PersonRepository {
    List<Person> personList;

    public PersonRepository() {
        this.personList = new ArrayList<>();
    }

    public void addPerson(Person person){
        personList.add(person);
    }

    public Person getPersonByIdx(int index){
        return personList.get(index);
    }

    public String getRoleByPersonIdx(int index){
        return personList.get(index).getRole();
    }

    public List<Person> getAllPersons(){
        return personList;
    }
}
