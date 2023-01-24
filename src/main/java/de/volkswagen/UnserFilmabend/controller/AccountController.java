package de.volkswagen.UnserFilmabend.controller;

import de.volkswagen.UnserFilmabend.dto.LoginData;
import de.volkswagen.UnserFilmabend.model.Account;
import de.volkswagen.UnserFilmabend.model.Genre;
import de.volkswagen.UnserFilmabend.service.AccountService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

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

    @PostMapping("/accounts/{accountId}/favGenres")
    public ResponseEntity<Account> addFavGenre(@PathVariable long accountId, @RequestBody Genre genre){
        Account acc;
        try{
            acc = accountService.addFavGenre(accountId, genre);
        }catch (RuntimeException e){
            return ResponseEntity.status(418).build();
        }
        return ResponseEntity.ok(acc);
    }

    @GetMapping("/usernames")
    public ResponseEntity<List<String>> getAllUsernames(){
        return ResponseEntity.ok(accountService.getAllUsernames());
    }
}