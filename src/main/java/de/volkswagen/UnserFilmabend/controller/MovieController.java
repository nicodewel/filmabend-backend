package de.volkswagen.UnserFilmabend.controller;

import de.volkswagen.UnserFilmabend.model.Genre;
import de.volkswagen.UnserFilmabend.model.Movie;
import de.volkswagen.UnserFilmabend.service.MovieService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    public MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getMoviesFromApi(){
        return ResponseEntity.ok(new ArrayList<Movie>());
    }

    @GetMapping("movies/genres")
    public ResponseEntity<List<Genre>> getAllGenreMovies() {
        return ResponseEntity.ok(movieService.getGenres());
    }
}