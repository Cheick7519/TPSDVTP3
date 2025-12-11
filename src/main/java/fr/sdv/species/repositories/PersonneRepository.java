package fr.sdv.species.repositories;

import fr.sdv.species.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface PersonneRepository extends JpaRepository<Person, Long>, PersonRepositoryCustom {

  Person findByFirstname(String firstname);


  // Find persons by last name OR first name
  List<Person> findByLastnameOrFirstname(String lastname, String firstname);

  // Find persons with age >= parameter
  List<Person> findByAgeGreaterThanEqual(int age);

  //À l’aide de l’annotation @Query :
  // 3. Écrire une méthode qui va chercher les Personnes dont l’âge est entre « age min » et « age max ».
  @Query("SELECT p FROM Person p WHERE p.age BETWEEN :ageMin AND :ageMax")
  List<Person> findByAgeBetween(int ageMin, int ageMax);
  // 4. [Difficile] Écrire une méthode qui va chercher toutes les Personnes qui possèdent l’animal donné en paramètre
  //Indice : utiliser une jointure (inner join) vers Animal OU utiliser l’opérateur MEMBEROF
  @Query("SELECT p FROM Person p JOIN p.animals a WHERE a.id = :animalId")
  List<Person> findByAnimalId(int animalId);
 // Générer x entités Person aléatoires




}
