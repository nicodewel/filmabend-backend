package de.volkswagen.UnserFilmabend.model;



import javax.persistence.*;
import java.util.Set;


@Entity
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(unique = true)
    private String name;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Movie> favoriteMovies;
    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.PERSIST)
    private Set<Genre> favoriteGenres;
    private String passwordHash;
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Movie> getFavoriteMovies() {
        return favoriteMovies;
    }

    public void setFavoriteMovies(Set<Movie> favoriteMovies) {
        this.favoriteMovies = favoriteMovies;
    }

    public Set<Genre> getFavoriteGenres() {
        return favoriteGenres;
    }

    public void setFavoriteGenres(Set<Genre> favoriteGenres) {
        this.favoriteGenres = favoriteGenres;
    }

    public String getPasswordHash() {
        return passwordHash;
    }

    public void setPasswordHash(String passwordHash) {
        this.passwordHash = passwordHash;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}