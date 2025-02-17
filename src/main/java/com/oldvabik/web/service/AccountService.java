package com.oldvabik.web.service;

import com.oldvabik.web.model.Account;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AccountService {
    List<Account> findAllAccounts();
    Account saveAccount(Account account);
    Account findByEmail(String email);
    Account updateAccount(Account account);
    void deleteAccount(String email);
    List<Account> searchAccounts(String name, String email);
}
