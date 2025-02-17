package com.oldvabik.web.service.impl;

import com.oldvabik.web.model.Account;
import com.oldvabik.web.repository.InMemoryAccountDAO;
import com.oldvabik.web.service.AccountService;
import java.util.List;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
@AllArgsConstructor
public class InMemoryAccountServiceImpl implements AccountService {
    @SuppressWarnings({"checkstyle:MemberName", "checkstyle:AbbreviationAsWordInName"})
    private InMemoryAccountDAO repository;

    @Override
    public List<Account> findAllAccounts() {
        return repository.findAllAccounts();
    }

    @Override
    public Account saveAccount(Account account) {
        return repository.saveAccount(account);
    }

    @Override
    public Account findByEmail(String email) {
        return repository.findByEmail(email);
    }

    @Override
    public Account updateAccount(Account account) {
        return repository.updateAccount(account);
    }

    @Override
    public void deleteAccount(String email) {
        repository.deleteAccount(email);
    }

    @Override
    public List<Account> searchAccounts(String name, String role) {
        return repository.searchAccounts(name, role);
    }
}
