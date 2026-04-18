package com.example.thornofkings.service;

import com.example.thornofkings.dto.account.AccountDto;
import com.example.thornofkings.dto.account.AccountRequest;
import com.example.thornofkings.entity.Account;
import com.example.thornofkings.mapper.AccountDtoMapper;
import com.example.thornofkings.repository.AccountRepository;
import com.example.thornofkings.util.PasswordUtil;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.stereotype.Service;

import javax.security.auth.login.AccountNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class AccountService {

    private final AccountRepository accountRepository;
    private final ServiceHelper serviceHelper;

    @Autowired
    public AccountService(AccountRepository accountRepository, ServiceHelper serviceHelper) {
        this.accountRepository = accountRepository;
        this.serviceHelper = serviceHelper;
    }

    public AccountDto getAccount(Long id) throws AccountNotFoundException {
        Account currentAccount = serviceHelper.getAccountByIdOrThrow(id);
        return AccountDtoMapper.toAccountDto(currentAccount); // WIP
    }

    public AccountDto createAccount(@Valid AccountRequest accountRequest) {
        String email = accountRequest.email().toLowerCase();
        Optional<Account> existingAccount = accountRepository.findByEmail(email);

        if(existingAccount.isPresent()) {
            throw new IllegalArgumentException("Email is already in use.");
        }

        Account account = new Account();
        account.setUsername(accountRequest.username());
        account.setEmail(accountRequest.email());
        account.setPasswordHash(PasswordUtil.hashPassword(accountRequest.passwordHash()));
        account.setCreatedAt(LocalDateTime.now());
        account.setUpdatedAt(null);

        accountRepository.save(account);

        return AccountDtoMapper.toAccountDto(account);
    }

    public void deleteAccount(Long id) throws AccountNotFoundException {
        Account currentAccount = serviceHelper.getAccountByIdOrThrow(id);
        accountRepository.deleteById(currentAccount.getId());
    }
}
