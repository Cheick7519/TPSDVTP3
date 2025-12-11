package fr.sdv.species.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepositoryCustom {
    // Ajouter une méthode pour supprimer toutes les personnes qui n’ont pas d’animaux
    void deletePersonsWithoutAnimals();
    // Ajouter une méthode pour générer x entités Person aléatoires
    void generateRandomPersons(int x);
}
