package fr.sdv.species.repositories;

import fr.sdv.species.model.Animal;
import fr.sdv.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@Repository
public interface AnimalRepository extends JpaRepository<Animal, Long> {
    Animal findByName(String name);

    // 1. Tous les animaux d'une species donnée
    List<Animal> findBySpecies(Species species);

    // 2. Tous les animaux dont la couleur est dans la liste fournie
    List<Animal> findByColorIn(List<String> colors);

    // À l’aide de l’annotation @Query :
    // 3. Requête qui renvoie le nombre d’Animaux dont le Sex est égal à la valeur donnée en paramètres
    @Query("SELECT count(a) FROM Animal a WHERE a.sex = :sex")
    int findNumberBySex(@Param("sex") String sex);
    // 4. [Très difficile] Requête qui renvoie un booléen si l’animal fourni « appartient » à au moins une personne
    @Query("SELECT CASE WHEN COUNT(p) > 0 THEN true ELSE false END FROM Person p JOIN p.animals a WHERE a = :animal")
    boolean existsByAnimal(@Param("animal") Animal animal);



}
