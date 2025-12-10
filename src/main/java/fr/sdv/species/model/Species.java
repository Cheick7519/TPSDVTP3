package fr.sdv.species.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "species")
public class Species {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "common_name", nullable = false)
    private String commonName;
    @Column(name = "latin_name", nullable = false)
    private String latinName;

    @OneToMany(mappedBy = "species", cascade = CascadeType.ALL)
    private List<Animal> animals = new ArrayList<>();

    // Getters and Setters
    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }


}
