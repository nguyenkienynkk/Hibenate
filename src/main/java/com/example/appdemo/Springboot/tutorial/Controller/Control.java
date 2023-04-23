package com.example.appdemo.Springboot.tutorial.Controller;

import com.example.appdemo.Springboot.tutorial.Repository.Repo;
import com.example.appdemo.Springboot.tutorial.Service.PersonService;
import com.example.appdemo.Springboot.tutorial.Entity.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;



@RestController
@RequestMapping("/api")
public class Control {
    private final Logger log = LoggerFactory.getLogger(Control.class);
    private final PersonService personService;
    public Control(PersonService personService) {
        this.personService = personService;
    }

    /**
     * GET /persons : get all persons
     *
     * @return the ResponseEntity with status 200 (OK) and with body all persons
     */
    @GetMapping("/persons")
    public  List<Person> getAllPerson() throws Exception {
        List persons = personService.getAllPerson();
        return persons;
    }
    /**
     * GET /person/{id} : get person by id
     *
     * @return the ResponseEntity with status 200 (OK) and with body person
     */
    @GetMapping("/person/{id}")
    public  Person getPersonById(@PathVariable Long id) throws Exception {
        Person person = personService.getPersonById(id);
        return person;
    }
    @GetMapping("/person/{sex}")
    public  Person getPersonBySexAndAgeAndPassword(@PathVariable String sex) throws Exception {
        Person person = personService.getPersonById(Long.valueOf(sex));
        return person;
    }

    /**
     * POST /person : create person
     *
     * @return the ResponseEntity with status 200 (OK) and with create product
     */
    @PostMapping("/person")
    public  Person createPerson(@RequestBody Person person) throws Exception {
        return personService.createPerson(person);
    }

    /**
     * PUT /product : update product
     *
     * @return the ResponseEntity with status 200 (OK) and with create person
     */
    @PutMapping("/person/{id}")
    public Person updatePerson(@RequestBody Person person) throws Exception {
        return personService.updatePerson(person);
    }

    @DeleteMapping("/person/{id}")
    public String deletePesonById(@PathVariable String id) throws Exception {
        return personService.deletePersonById(Long.valueOf(id));
    }
    //sex

    @DeleteMapping("/person/{id}/{sex}")
    public String deletePesonBySex(@PathVariable String sex) throws Exception {
        return personService.deletePersonById(Long.valueOf(sex));
    }
    @DeleteMapping("/person/{id}/{age}")
    public String deletePesonByAge(@PathVariable String age) throws Exception {
        return personService.deletePersonById(Long.valueOf(age));
    }

}