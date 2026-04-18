package com.example.thornofkings.dto.account;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record AccountRequest(@NotNull String name,
                             @Email @NotNull String email,
                             @NotNull @Size(min = 6, message = "Password must be at least 6 characters long") String passwordHash) {
}
