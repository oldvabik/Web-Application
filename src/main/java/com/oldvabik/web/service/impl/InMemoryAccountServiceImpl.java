package com.oldvabik.web.service.impl;

import com.oldvabik.web.model.Account;
import com.oldvabik.web.repository.InMemoryAccountDAO;
import com.oldvabik.web.service.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class InMemoryAccountServiceImpl implements AccountService {
    private final InMemoryAccountDAO REPOSITORY;

    @Override
    public List<Account> findAllAccounts() {
        return REPOSITORY.findAllAccounts();
    }

    @Override
    public Account saveAccount(Account account) {
        return REPOSITORY.saveAccount(account);
    }

    @Override
    public Account findByEmail(String email) {
        return REPOSITORY.findByEmail(email);
    }

    @Override
    public Account updateAccount(Account account) {
        return REPOSITORY.updateAccount(account);
    }

    @Override
    public void deleteAccount(String email) {
        REPOSITORY.deleteAccount(email);
    }

    @Override
    public List<Account> searchAccounts(String name, String role) {
        return REPOSITORY.searchAccounts(name, role);
    }
}
