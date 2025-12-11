package fr.sdv.species.repositories;

import fr.sdv.species.model.Person;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

import java.util.List;

public class PersonRepositoryCustomImpl implements PersonRepositoryCustom {

    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Delete all Person entities that do not have any associated Animal entities.
     */
    @Override
    public void deletePersonsWithoutAnimals() {
        //String jpql = "DELETE FROM Person p WHERE p.animals IS EMPTY";
        // requête avec jointure
        //String jpql = "DELETE FROM Person p WHERE p.id NOT IN (SELECT DISTINCT pa.id FROM Person pa JOIN pa.animals a)";
        List<Person> personsWithoutAnimals = entityManager.createQuery(
                "SELECT p FROM Person p WHERE p.animals IS EMPTY", Person.class)
                .getResultList();
        for (Person person : personsWithoutAnimals) {
            entityManager.remove(person);
        }

    }

    /**
     * Generate x random Person entities and persist them to the database.
     * @param x
     */
    @Override
    public void generateRandomPersons(int x) {
        for (int i = 0; i < x; i++) {
            Person person = new Person();
            person.setFirstname("FirstName" + Math.random());
            person.setLastname("LastName" + Math.random());
            person.setAge((int) (Math.random() * 100));
            person.setLogin("user" + Math.random());
            person.setMdp("password" + Math.random());
            person.setActive((byte) 1);
            entityManager.persist(person);
        }
    }
}
