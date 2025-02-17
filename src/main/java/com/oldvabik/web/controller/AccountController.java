package com.oldvabik.web.controller;

import com.oldvabik.web.model.Account;
import com.oldvabik.web.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {
    private final AccountService ACCOUNT_SERVICE;

    @GetMapping
    public List<Account> findAllAccounts() {
        return ACCOUNT_SERVICE.findAllAccounts();
    }

    @PostMapping
    public Account saveAccount(@RequestBody Account account) {
        return ACCOUNT_SERVICE.saveAccount(account);
    }

    @GetMapping("/{email}")
    public Account findByEmail(@PathVariable String email) {
        return ACCOUNT_SERVICE.findByEmail(email);
    }

    @PutMapping
    public Account updateAccount(Account account) {
        return ACCOUNT_SERVICE.updateAccount(account);
    }

    @DeleteMapping("/{email}")
    public void deleteAccount(@PathVariable String email) {
        ACCOUNT_SERVICE.deleteAccount(email);
    }

    @GetMapping("/search")
    public List<Account> searchAccounts(@RequestParam String name, @RequestParam String role) {
        return ACCOUNT_SERVICE.searchAccounts(name, role);
    }
}
