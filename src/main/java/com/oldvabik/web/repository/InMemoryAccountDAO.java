package com.oldvabik.web.repository;

import com.oldvabik.web.model.Account;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import org.springframework.stereotype.Repository;

@SuppressWarnings("checkstyle:AbbreviationAsWordInName")
@Repository
public class InMemoryAccountDAO {
    @SuppressWarnings("checkstyle:MemberName")
    private List<Account> accounts = new ArrayList<>();

    public List<Account> findAllAccounts() {
        return accounts;
    }

    public Account saveAccount(Account account) {
        accounts.add(account);
        return account;
    }

    public Account findByEmail(String email) {
        return accounts.stream()
                .filter(element -> element.getEmail().equals(email))
                .findFirst()
                .orElse(null);
    }

    public Account updateAccount(Account account) {
        var accountIndex = IntStream.range(0, accounts.size())
                .filter(index -> accounts.get(index).getEmail().equals(account.getEmail()))
                .findFirst()
                .orElse(-1);
        if (accountIndex > -1) {
            accounts.set(accountIndex, account);
            return account;
        }
        return null;
    }

    public void deleteAccount(String email) {
        var account = findByEmail(email);
        if (account != null) {
            accounts.remove(account);
        }
    }

    public List<Account> searchAccounts(String name, String role) {
        return accounts.stream()
                .filter(account -> (name == null || account.getName().equalsIgnoreCase(name))
                        && (role == null || account.getRole().equalsIgnoreCase(role)))
                .toList();
    }
}
