package de.volkswagen.UnserFilmabend.service;

import de.volkswagen.UnserFilmabend.dto.LoginData;
import de.volkswagen.UnserFilmabend.model.Account;
import de.volkswagen.UnserFilmabend.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

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
        };
        throw new RuntimeException();
    };

}