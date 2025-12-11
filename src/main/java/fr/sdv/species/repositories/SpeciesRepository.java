package fr.sdv.species.repositories;

import fr.sdv.species.model.Species;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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
    // 3. À l’aide de l’annotation @Query :
    // Écrire une méthode qui va aller chercher toutes les Species, ordonnées par nom commun ascendant.
    @Query("SELECT s FROM Species s ORDER BY s.commonName ASC")
    List<Species> findAllOrderByCommonNameAsc();
    // 4. Écrire une méthode qui retourne les Species avec un nom commun LIKE le paramètre fourni
    @Query("SELECT s FROM Species s WHERE s.commonName LIKE :commonName")
    List<Species> findByCommonNameLike(@Param("commonName") String commonName);


}
