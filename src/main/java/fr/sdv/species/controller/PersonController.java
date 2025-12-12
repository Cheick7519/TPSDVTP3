package fr.sdv.species.controller;

import fr.sdv.species.model.Person;
import fr.sdv.species.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/persons")
public class PersonController {

    private final PersonService personService;

    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    // CREATE
    @PostMapping("/create")
    public String createPerson(@RequestBody Person person) {
        return personService.createPerson(person);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String updatePerson(@PathVariable int id, @RequestBody Person person) {
        person.setId(id); // on s’assure que la personne a bien l'id à modifier
        return personService.updatePerson(person);
    }

    // READ - GET ALL
    @GetMapping("/all")
    public List<Person> findAllPersons() {
        return personService.findAllPersons();
    }

    // READ - GET BY ID
    @GetMapping("/{id}")
    public Person findPersonById(@PathVariable Long id) {
        return personService.findPersonById(id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deletePersonById(@PathVariable Long id) {
        return personService.deletePersonById(id);
    }
}
