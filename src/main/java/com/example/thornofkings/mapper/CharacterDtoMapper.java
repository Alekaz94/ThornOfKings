package com.example.thornofkings.mapper;

import com.example.thornofkings.dto.character.CharacterDto;
import com.example.thornofkings.entity.character.Character;

public class CharacterDtoMapper {
    public static CharacterDto toCharacterDto(Character character) {
        if(character == null) {
            return null;
        }

        return new CharacterDto(
                character.getId(),
                character.getAccount(),
                character.getCreatedAt(),
                character.getCharacterName(),
                character.getCharacterGender(),
                character.getLevel(),
                character.getCurrentExperiencePoints(),
                character.getExperiencePointsToLevel(),
                character.getTrainingPoints(),
                character.getCharacterItems().stream().toList(),
                character.getWallet(),
                character.getHealth(),
                character.getEnergy(),
                character.getBaseStats()
        );
    }
}
