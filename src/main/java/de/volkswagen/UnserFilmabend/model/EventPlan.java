package de.volkswagen.UnserFilmabend.model;

import lombok.Data;

import javax.persistence.*;
import java.time.Instant;
import java.util.Set;

@Data
@Entity
public class EventPlan {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private Instant date;
    @ManyToOne
    private Account host;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Movie> selectedMovies;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Genre> selectedGenres;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Account> invitedUsers;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Account> confirmedUsers;
    private boolean isRemote;
}