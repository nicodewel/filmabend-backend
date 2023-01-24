package de.volkswagen.UnserFilmabend.service;

import de.volkswagen.UnserFilmabend.dto.LoginData;
import de.volkswagen.UnserFilmabend.model.Account;
import de.volkswagen.UnserFilmabend.model.Genre;
import de.volkswagen.UnserFilmabend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account loginUser(LoginData loginData) {
        Optional<Account> dbAccount = accountRepository.findByName(loginData.getName());
        if (!dbAccount.isPresent()) {
            throw new RuntimeException();
        }
        if (dbAccount.get().getPasswordHash().equals(loginData.getPasswordHash())) {
            return dbAccount.get();
        }
        ;
        throw new RuntimeException();
    }

    ;

    public Account addFavGenre(long id, Genre genre) {
        Optional<Account> accToExtendOptional = accountRepository.findById(id);
        if (!accToExtendOptional.isPresent()) {
            throw new RuntimeException();
        }
        else {
            Account accToExtend = accToExtendOptional.get();
            accToExtend.getFavoriteGenres().add(genre);
            return accountRepository.save(accToExtend);
        }

    }

    public List<String> getAllUsernames() {
        List<String> usernames = new ArrayList<>();
        accountRepository.findAll().forEach(account -> usernames.add(account.getName()));
        return usernames;
    }
}