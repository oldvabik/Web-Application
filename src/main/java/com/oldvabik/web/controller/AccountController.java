package com.oldvabik.web.controller;

import com.oldvabik.web.model.Account;
import com.oldvabik.web.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/accounts")
@AllArgsConstructor
public class AccountController {
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    private AccountService accountService;

    @GetMapping
    public List<Account> findAllAccounts() {
        return accountService.findAllAccounts();
    }

    @PostMapping
    public Account saveAccount(@RequestBody Account account) {
        return accountService.saveAccount(account);
    }

    @GetMapping("/{email}")
    public Account findByEmail(@PathVariable String email) {
        return accountService.findByEmail(email);
    }

    @PutMapping
    public Account updateAccount(Account account) {
        return accountService.updateAccount(account);
    }

    @DeleteMapping("/{email}")
    public void deleteAccount(@PathVariable String email) {
        accountService.deleteAccount(email);
    }

    @GetMapping("/search")
    public List<Account> searchAccounts(@RequestParam String name, @RequestParam String role) {
        return accountService.searchAccounts(name, role);
    }
}
