package de.volkswagen.UnserFilmabend.controller;

import de.volkswagen.UnserFilmabend.dto.LoginData;
import de.volkswagen.UnserFilmabend.model.Account;
import de.volkswagen.UnserFilmabend.service.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    AccountService accountService;

    public AccountController(AccountService accountService) {
        this.accountService = accountService;
    }

    @PostMapping("/login")
    public ResponseEntity<Account> userLogin(@RequestBody LoginData loginData) {
        Account account;
        try {
            account = accountService.loginUser(loginData);
        } catch (RuntimeException e) {
            return ResponseEntity.status(401).build();
        }
        return ResponseEntity.ok(account);
    }

}