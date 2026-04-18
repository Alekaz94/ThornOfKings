package com.example.thornofkings.service;

import com.example.thornofkings.entity.Account;
import com.example.thornofkings.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;

@Service
public class ServiceHelper {

    private final AccountRepository accountRepository;

    @Autowired
    public ServiceHelper(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getAccountByIdOrThrow(Long id) throws AccountNotFoundException {
        return accountRepository.findById(id).orElseThrow(() ->
                new AccountNotFoundException("Could not find account."));
    }

    public Account getAccountByEmailOrThrow(String email) throws AccountNotFoundException {
        return accountRepository.findByEmail(email).orElseThrow(() ->
                new AccountNotFoundException("Could not find account."));
    }
}
