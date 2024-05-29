package com.Crudsample.crud.repository;


import com.Crudsample.crud.model.Person;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class PersonRepository {
    private Map<Integer,Person> map = new HashMap<>();

    public String saveAll(Person person){
        map.put(person.getPerson_id(), person);
        return "your person details has beed saved";
    }

    public Person getPersonDetails(int personId) {
        return map.get(personId);
    }

    public Person updatePersonDetails(int personId, Person updatedPerson) throws Exception {
        if (map.containsKey(personId)) {
            map.put(personId, updatedPerson);
            return updatedPerson;
        }
        return null; // or throw an exception if personId does not exist
    }

    public Person deletePersonDetails(int personId) {
        return map.remove(personId);
    }
}
