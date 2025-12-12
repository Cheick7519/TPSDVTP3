package fr.sdv.species.service;

import fr.sdv.species.model.Person;
import fr.sdv.species.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    private final PersonRepository personRepository;
    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }
    // Séparer la méthode Create de la méthode Update (faire deux méthodes distinctes)
   public String createPerson(Person person) {
         personRepository.save(person);
       return "Create Person method called";
   }
   // method to update a person
    public String updatePerson(Person person) {
        Person existingPerson = personRepository.findById((long) person.getId())
                .orElseThrow(() -> new IllegalArgumentException("Person not found with id: " + person.getId()));
            personRepository.save(person);
         return "Update Person method called";
    }
    // Pour les autres, faire des méthodes « passe-plats » qui appellent simplement une
    //méthode du repository et renvoient son résultat.
    // FindAll
    public List<Person> findAllPersons() {
        return personRepository.findAll();
    }
    // FindById
    public Person findPersonById(Long id) {
        return personRepository.findById(id).orElse(null);
    }
    // DeleteById
    public String deletePersonById(Long id) {
        personRepository.deleteById(id);
        return "Person deleted successfully";
    }


}
