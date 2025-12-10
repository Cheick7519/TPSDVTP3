package fr.sdv.species.repositories;

import fr.sdv.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SpeciesRepository extends JpaRepository<Species, Long> {
    Optional<Species> findById(int id);

    // 1. Find the first Species by common name (exact match)
    Optional<Species> findFirstByCommonName(String commonName);

    // 2. Find all Species where latin name contains substring, case-insensitive
    List<Species> findByLatinNameContains(String latinName);


}
