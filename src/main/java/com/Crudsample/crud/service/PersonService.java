package com.Crudsample.crud.service;

import com.Crudsample.crud.model.Person;
import com.Crudsample.crud.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PersonService{

    @Autowired
    private PersonRepository personRepository;
    public String savePersonDetails(Person person) {
        personRepository.saveAll(person);
    return "saved successfull";
    }

    public Person getPersonDetails(int person_Id) {
        return personRepository.getPersonDetails(person_Id);
    }

    public Person updatePersonDetails(int personId, Person personUpdate) throws  Exception{
        return personRepository.updatePersonDetails(personId,personUpdate);
    }

    public Person deletePersonDetails(int personId) {
        return personRepository.deletePersonDetails(personId);
    }

    public List<Person> getAllDetails() {
        return personRepository.getAllPersonDetails();
    }
}
