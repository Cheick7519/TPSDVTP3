package fr.sdv.species;

import fr.sdv.species.repositories.AnimalRepository;
import fr.sdv.species.repositories.PersonneRepository;
import fr.sdv.species.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;

@SpringBootApplication
public class SpeciesApplication implements CommandLineRunner{

    @Autowired
    private AnimalRepository animalRepository;

    @Autowired
    private SpeciesRepository speciesRepository;

    @Autowired
    private PersonneRepository personneRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpeciesApplication.class, args);
    }
    @Transactional
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Species Application is running...");

        // Testing repositories
        long animalCount = animalRepository.count();
        long speciesCount = speciesRepository.count();

        System.out.println("Number of animals: " + animalCount);
        System.out.println("Number of species: " + speciesCount);

        // Print Name of the first person if exists
        personneRepository.findAll().stream().findFirst().ifPresent(person -> {
            System.out.println("First person's name: " + person.getName());
        });
        // Add more test cases as needed
        // 1. Find the first Species by common name (exact match)
        System.out.println(" Finding first Species by common name 'Lion': ");
        speciesRepository.findFirstByCommonName("Lapin").ifPresent(species -> {
            System.out.println("Found Species: " + species.getCommonName() + " (" + species.getLatinName() + ")");
        });
        // Retourner les Species avec un nom commun LIKE le paramètre fourni
        System.out.println(" Finding Species with common name like 'a': ");
        speciesRepository.findByCommonNameLike("a").forEach(species -> {
            System.out.println("Found Species: " + species.getCommonName() + " (" + species.getLatinName() + ")");
        });
        // Chercher toutes les Species, ordonnées par nom commun ascendant
        System.out.println(" All Species ordered by common name ascending: ");
        speciesRepository.findAllOrderByCommonNameAsc().forEach(species -> {
            System.out.println("Species: " + species.getCommonName() + " (" + species.getLatinName() + ")");
        });
        // Chercher les Personnes dont l’âge est entre « age min » et « age max ».
        System.out.println(" Finding Persons with age between 20 and 30: ");
        personneRepository.findByAgeBetween(20, 30).forEach(person -> {
            System.out.println("Found Person: " + person.getName() + ", Age: " + person.getAge());
        });
        // Chercher toutes les Personnes qui possèdent l’animal donné en paramètre
        System.out.println(" Finding Persons who own the animal with ID 1: ");
        personneRepository.findByAnimalId(1).forEach(person -> {
            System.out.println("Found Person: " + person.getName());
        });

        // Requête qui renvoie le nombre d’Animaux dont le Sex est égal à la valeur donnée en paramètres
        System.out.println("Number of Animal by sex in param");
        System.out.println(animalRepository.findNumberBySex("M"));
        // Requête qui renvoie un booléen si l’animal fourni « appartient » à au moins une personne
        System.out.println("Boolean if the animal belongs to at least one person");
        System.out.println(animalRepository.existsByAnimal(animalRepository.findById(1L).orElse(null)));


        // Générer 5 personnes aléatoires
        personneRepository.generateRandomPersons(1);

        // Afficher le nombre total de personnes après génération
        System.out.println("Nombre total de personnes après génération : " + personneRepository.count());
        // Supprimer toutes les personnes qui n’ont pas d’animaux
        personneRepository.deletePersonsWithoutAnimals();
        // Supprimer les personnes à partir de son nom
        personneRepository.deleteByLastname("Wagner");
        // Afficher le nombre total de personnes après suppression
        System.out.println("Nombre total de personnes après suppression : " + personneRepository.count());



    }
}
