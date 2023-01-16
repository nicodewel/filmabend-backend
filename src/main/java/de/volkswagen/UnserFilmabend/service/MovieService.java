package de.volkswagen.UnserFilmabend.service;

import de.volkswagen.UnserFilmabend.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    private MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }
}