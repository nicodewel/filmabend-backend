package de.volkswagen.UnserFilmabend.repository;

import de.volkswagen.UnserFilmabend.model.Movie;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MovieRepository extends PagingAndSortingRepository<Movie,Long> {
}