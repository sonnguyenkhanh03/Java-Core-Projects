package com.safemove.backend.controller;

import com.safemove.backend.entity.Account;
import com.safemove.backend.repository.AccountRepository;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
public class AccountController {
    private final AccountRepository accountRepository;

    public AccountController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping
    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    @PostMapping
    public Account create(@Valid @RequestBody Account account) {
        return accountRepository.save(account);
    }
}
