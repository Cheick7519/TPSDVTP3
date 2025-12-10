package fr.sdv.species.repositories;

import fr.sdv.species.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Person, Long> {

  Person findByFirstname(String firstname);

  // Find persons by last name OR first name
  List<Person> findByLastnameOrFirstname(String lastname, String firstname);

  // Find persons with age >= parameter
  List<Person> findByAgeGreaterThanEqual(int age);




}
