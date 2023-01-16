package de.volkswagen.UnserFilmabend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToMany(cascade = CascadeType.PERSIST, fetch = FetchType.LAZY)
    private Set<Genre> genre;
    private String imdb_id;
    private String original_title;
    private String title;
}