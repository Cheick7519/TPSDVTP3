package fr.sdv.species.repositories;

import fr.sdv.species.model.Animal;
import fr.sdv.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);

    // 1. Tous les animaux d'une species donnée
    List<Animal> findBySpecies(Species species);

    // 2. Tous les animaux dont la couleur est dans la liste fournie
    List<Animal> findByColorIn(List<String> colors);

}
