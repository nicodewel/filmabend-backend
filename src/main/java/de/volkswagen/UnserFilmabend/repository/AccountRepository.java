package de.volkswagen.UnserFilmabend.repository;

import de.volkswagen.UnserFilmabend.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountRepository extends CrudRepository<Account, Long> {
}