package com.example.thornofkings.mapper;

import com.example.thornofkings.dto.account.AccountDto;
import com.example.thornofkings.entity.Account;

import java.util.List;

public class AccountDtoMapper {
    public static AccountDto toAccountDto(Account account) {
        if(account == null) {
            return null;
        }

        return new AccountDto(
                account.getId(),
                account.getUsername(),
                account.getEmail(),
                account.getCreatedAt(),
                account.getUpdatedAt()
        );
    }

    public static List<AccountDto> toAccountDtoList(List<Account> accounts) {
        return accounts
                .stream()
                .map(AccountDtoMapper::toAccountDto)
                .toList();
    }
}
