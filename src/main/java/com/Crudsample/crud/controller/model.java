package com.Crudsample.crud.controller;


import com.Crudsample.crud.model.Person;
import com.Crudsample.crud.service.PersonService;
import jakarta.servlet.annotation.ServletSecurity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

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
    public Person updatePersonDetails(@RequestParam("person_id") int person_id,@RequestBody Person updatedPerson) throws Exception{
        return personService.updatePersonDetails(person_id,updatedPerson);
    }
    @DeleteMapping("deleteById")
    public Person deleteById(@RequestParam("person_id") int person_id){
        return personService.deletePersonDetails(person_id);
    }


}
