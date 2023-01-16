package de.volkswagen.UnserFilmabend.model;


import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Movie> favorites;
}