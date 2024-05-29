package com.Crudsample.crud.controller;


import com.Crudsample.crud.model.Person;
import com.Crudsample.crud.service.PersonService;
import jakarta.servlet.annotation.ServletSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.net.http.HttpResponse;
import java.util.List;

@RestController
@RequestMapping("person")
@Controller
public class model {

    @Autowired
    private PersonService personService;
    @GetMapping("pershon-details")
    public  String personDetails(){
        return "Hey i am Rajesh kumar , graduate in 2022";
    }


    @PostMapping("person-details")
    public String savePersonDetails(@RequestBody Person person){
        personService.savePersonDetails(person);
        return "person details has been saved";


    }
    @GetMapping("findAll")
    public Person getPersonDetails(@RequestParam("person_id") int person_id){
        return personService.getPersonDetails(person_id);


    }
    @PutMapping("update")
    public Person updatePersonDetails(@RequestParam("person_id") int person_id,
                                                   @RequestBody Person updatedPerson) throws Exception{
        return personService.updatePersonDetails(person_id, updatedPerson);

//        try {
//            Person updated = personService.updatePersonDetails(person_id, updatedPerson);
//            return new ResponseEntity<>(updated, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
//        }
    }
    @DeleteMapping("deleteById")
    public Person deleteById(@RequestParam("person_id") int person_id){
        return personService.deletePersonDetails(person_id);
    }

    @GetMapping("Alldetails")
    public List<Person> findAll() {
        return personService.getAllDetails();
    }

}
