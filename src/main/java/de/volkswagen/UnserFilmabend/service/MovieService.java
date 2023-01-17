package de.volkswagen.UnserFilmabend.service;

import de.volkswagen.UnserFilmabend.model.Genre;
import de.volkswagen.UnserFilmabend.repository.GenreRepository;
import de.volkswagen.UnserFilmabend.repository.MovieRepository;
import org.springframework.http.client.SimpleClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.InetSocketAddress;
import java.net.Proxy;
import java.util.Arrays;
import java.util.List;

@Service
public class MovieService {

    private final MovieRepository movieRepository;
    private final GenreRepository genreRepository;

    public MovieService(MovieRepository movieRepository, GenreRepository genreRepository) {
        this.movieRepository = movieRepository;
        this.genreRepository = genreRepository;
    }

    public  List<Genre> getGenres() {

        String uri = "https://api.themoviedb.org/3/genre/movie/list?api_key=e173ba193d1b0380036cf7f73f4c9891&language=en-US";
        RestTemplate restTemplate = new RestTemplate();
        List<Genre> result = Arrays.asList(restTemplate.getForObject(uri, Genre[].class));
        genreRepository.saveAll(result);
        return result;

    }
}