/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.mappers;


import com.disney.challenge.dtos.*;
import com.disney.challenge.entities.Character;

import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface CharacterMapper  {

    CharacterSlimDTO characterToCharacterSlimDto(Character character);

    CharacterDTO characterToCharacterDto(Character character);

    Character characterDtoToCharacter(CharacterDTO character);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
                 nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Character updateCharacterFromDTO(CharacterDTO characterDTO, @MappingTarget Character character);

    List<CharacterSlimDTO> charactersToCharacterSlimDtos(List<Character> characters);

    List<CharacterDTO> charactersToCharacterDtos(List<Character> characters);

    
}

