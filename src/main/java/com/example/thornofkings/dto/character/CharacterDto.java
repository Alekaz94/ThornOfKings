package com.example.thornofkings.dto.character;

import com.example.thornofkings.entity.Account;
import com.example.thornofkings.entity.CharacterItem;
import com.example.thornofkings.entity.Wallet;
import com.example.thornofkings.entity.character.embeddables.BaseStats;
import com.example.thornofkings.entity.character.embeddables.Energy;
import com.example.thornofkings.entity.character.embeddables.Health;
import com.example.thornofkings.entity.character.enums.CharacterGender;

import java.time.LocalDateTime;
import java.util.List;

public record CharacterDto(Long id,
                           Account account,
                           LocalDateTime createdAt,
                           String characterName,
                           CharacterGender characterGender,
                           int level,
                           int currentExperiencePoints,
                           int experiencePointsToLevel,
                           int trainingPoints,
                           List<CharacterItem> characterItems,
                           Wallet wallet,
                           Health health,
                           Energy energy,
                           BaseStats baseStats) {
}
