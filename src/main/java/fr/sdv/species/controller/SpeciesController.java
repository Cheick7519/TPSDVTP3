package fr.sdv.species.controller;

import fr.sdv.species.model.Species;
import fr.sdv.species.service.SpeciesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/species")
public class SpeciesController {

    private final SpeciesService speciesService;

    @Autowired
    public SpeciesController(SpeciesService speciesService) {
        this.speciesService = speciesService;
    }

    // CREATE
    @PostMapping("/create")
    public String createSpecies(@RequestBody Species species) {
        return speciesService.createSpecies(species);
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public String updateSpecies(@PathVariable int id, @RequestBody Species species) {
        species.setId(id); // on force l'id à celui de l'URL
        return speciesService.updateSpecies(species);
    }

    // GET ALL
    @GetMapping("/all")
    public List<Species> findAllSpecies() {
        return speciesService.findAllSpecies();
    }

    // GET BY ID
    @GetMapping("/{id}")
    public Species findSpeciesById(@PathVariable Long id) {
        return speciesService.findSpeciesById(id);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteSpeciesById(@PathVariable Long id) {
        return speciesService.deleteSpeciesById(id);
    }
}
