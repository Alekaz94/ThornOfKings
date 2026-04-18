package com.example.thornofkings.dto.account;

import java.time.LocalDateTime;

public record AccountDto(Long id,
                         String username,
                         String email,
                         LocalDateTime createdAt,
                         LocalDateTime updatedAt) {
}
