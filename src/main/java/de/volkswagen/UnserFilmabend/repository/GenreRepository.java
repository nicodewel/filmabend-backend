package de.volkswagen.UnserFilmabend.repository;

import de.volkswagen.UnserFilmabend.model.Genre;
import org.springframework.data.repository.CrudRepository;

public interface GenreRepository extends CrudRepository<Genre,Integer> {

}