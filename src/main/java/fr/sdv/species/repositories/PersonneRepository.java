package fr.sdv.species.repositories;

import fr.sdv.species.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Person, Long> {

  Person findByFirstname(String firstname);



}
