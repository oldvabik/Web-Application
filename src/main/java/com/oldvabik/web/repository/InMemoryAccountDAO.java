package com.oldvabik.web.repository;

import com.oldvabik.web.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Repository
public class InMemoryAccountDAO {
    private final List<Account> ACCOUNTS = new ArrayList<>();

    public List<Account> findAllAccounts() {
        return ACCOUNTS;
    }

    public Account saveAccount(Account account) {
        ACCOUNTS.add(account);
        return account;
    }

    public Account findByEmail(String email) {
        return ACCOUNTS.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Account updateAccount(Account account) {
        var accountIndex = IntStream.range(0, ACCOUNTS.size())
                .filter(index -> ACCOUNTS.get(index).getEmail().equals(account.getEmail()))
                .findFirst()
                .orElse(-1);
        if (accountIndex > -1) {
            ACCOUNTS.set(accountIndex, account);
            return account;
        }
        return null;
    }

    public void deleteAccount(String email) {
        var account = findByEmail(email);
        if (account != null) {
            ACCOUNTS.remove(account);
        }
    }

    public List<Account> searchAccounts(String name, String role) {
        return ACCOUNTS.stream()
                .filter(account -> (name == null || account.getName().equalsIgnoreCase(name))
                        && (role == null || account.getRole().equalsIgnoreCase(role)))
                .toList();
    }
}
