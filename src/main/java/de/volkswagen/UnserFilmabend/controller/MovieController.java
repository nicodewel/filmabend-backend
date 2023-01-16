package de.volkswagen.UnserFilmabend.controller;

import de.volkswagen.UnserFilmabend.model.Movie;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MovieController {

    @GetMapping("movies")
    public ResponseEntity<List<Movie>> getMoviesFromApi(){
        return ResponseEntity.ok(new ArrayList<Movie>());
    }
}