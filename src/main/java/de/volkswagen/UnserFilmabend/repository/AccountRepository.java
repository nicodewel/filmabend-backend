package de.volkswagen.UnserFilmabend.repository;

import de.volkswagen.UnserFilmabend.model.Account;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AccountRepository extends CrudRepository<Account, Long> {
    public Optional<Account> findByName(String name);
}