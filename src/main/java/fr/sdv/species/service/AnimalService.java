package fr.sdv.species.service;

import fr.sdv.species.model.Animal;
import fr.sdv.species.repositories.AnimalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimalService {
    private final AnimalRepository animalRepository;
    @Autowired
    public AnimalService(AnimalRepository animalRepository) {
        this.animalRepository = animalRepository;
    }
    // Method to create an animal
    public String createAnimal(Animal animal) {
        animalRepository.save(animal);
        return "Create Animal method called";
    }
    // Method to update an animal
    public String updateAnimal(Animal animal) {
        Animal existingAnimal = animalRepository.findById((long) animal.getId())
                .orElseThrow(() -> new IllegalArgumentException("Animal not found with id: " + animal.getId()));
        animalRepository.save(animal);
        return "Update Animal method called";
    }
    // Méthode passe-plats pour les autres opérations CRUD
    // FindAll
    public List<Animal> findAllAnimals() {
        return animalRepository.findAll();
    }
    // FindById
    public Animal findAnimalById(Long id) {
        return animalRepository.findById(id).orElse(null);
    }
    // DeleteById
    public String deleteAnimalById(Long id) {
        animalRepository.deleteById(id);
        return "Animal deleted successfully";
    }
}
