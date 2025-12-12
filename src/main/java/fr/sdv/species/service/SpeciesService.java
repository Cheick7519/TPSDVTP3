package fr.sdv.species.service;
import fr.sdv.species.model.Species;
import fr.sdv.species.repositories.SpeciesRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class SpeciesService {
    private final SpeciesRepository speciesRepository;
    @Autowired
    public SpeciesService(SpeciesRepository speciesRepository) {
        this.speciesRepository = speciesRepository;
    }
    // Method to create a species
    public String createSpecies(Species species) {
        speciesRepository.save(species);
        return "Create Species method called";
    }
    // Method to update a species
    public String updateSpecies(Species species) {
        Species existingSpecies = speciesRepository.findById((long) species.getId())
                .orElseThrow(() -> new IllegalArgumentException("Species not found with id: " + species.getId()));
        speciesRepository.save(species);
        return "Update Species method called";
    }
    // Méthode passe-plats pour les autres opérations CRUD
    // FindAll
    public List<Species> findAllSpecies() {
        return speciesRepository.findAll();
    }
    // FindById
    public Species findSpeciesById(Long id) {
        return speciesRepository.findById(id).orElse(null);
    }
    // DeleteById
    public String deleteSpeciesById(Long id) {
        speciesRepository.deleteById(id);
        return "Species deleted successfully";
    }


}
