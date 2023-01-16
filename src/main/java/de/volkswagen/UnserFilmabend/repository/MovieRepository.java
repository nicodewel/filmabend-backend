package de.volkswagen.UnserFilmabend.repository;

import de.volkswagen.UnserFilmabend.model.Movie;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RestResource;

public interface MovieRepository extends PagingAndSortingRepository<Movie,Long> {

    @Override
    @RestResource(exported = false)
    Page<Movie> findAll(Pageable pageable);
}