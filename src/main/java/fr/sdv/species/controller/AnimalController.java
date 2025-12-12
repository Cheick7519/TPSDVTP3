package fr.sdv.species.controller;

import fr.sdv.species.model.Animal;
import fr.sdv.species.service.AnimalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/animals")
public class AnimalController {

    private final AnimalService animalService;

    @Autowired
    public AnimalController(AnimalService animalService) {
        this.animalService = animalService;
    }

    @PostMapping("/create")
    public String createAnimal(@RequestBody Animal animal) {
        return animalService.createAnimal(animal);
    }

    @PutMapping("/update")
    public String updateAnimal(@RequestBody Animal animal) {
        return animalService.updateAnimal(animal);
    }

    @GetMapping("/all")
    public List<Animal> findAllAnimals() {
        return animalService.findAllAnimals();
    }

    @GetMapping("/find/{id}")
    public Animal findAnimalById(@PathVariable Long id) {
        return animalService.findAnimalById(id);
    }

    @PostMapping("/delete/{id}")
    public String deleteAnimalById(@PathVariable Long id) {
        return animalService.deleteAnimalById(id);
    }
}
