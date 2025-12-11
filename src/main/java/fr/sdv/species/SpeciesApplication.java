package fr.sdv.species;

import fr.sdv.species.repositories.AnimalRepository;
import fr.sdv.species.repositories.PersonneRepository;
import fr.sdv.species.repositories.SpeciesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

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


    }
}
