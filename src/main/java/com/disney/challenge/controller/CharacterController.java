/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.controller;


import com.disney.challenge.services.*;
import com.disney.challenge.mappers.*;
import com.disney.challenge.dtos.*;
import com.disney.challenge.entities.Character;

import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Tag(name = "Characters")
@RestController
@RequestMapping("/characters")
public class CharacterController {

	
    private final CharacterMapper characterMapper;
    
    private final MovieMapper movieMapper;
    
    private final ICharacterService characterService;

    
    @GetMapping()
    public ResponseEntity<List<CharacterSlimDTO>> getAllCharacters() {
        return new ResponseEntity<>(characterMapper.charactersToCharacterSlimDtos(characterService.getAll()), HttpStatus.OK);
}

    
    @GetMapping("/{id}")
    public ResponseEntity<CharacterDTO> getCharacterById(@PathVariable("id") Long id) {
        return new ResponseEntity<>(characterMapper.characterToCharacterDto(characterService.findById(id)), HttpStatus.OK);
    }

    @GetMapping(params = "name")
    public ResponseEntity<List<CharacterDTO>> findCharacterByName(@Parameter(description = "Filter by name") @RequestParam(value = "name", required = false) String name) {
        return new ResponseEntity<>(characterMapper.charactersToCharacterDtos(characterService.findByName(name)), HttpStatus.OK);
    }

    @GetMapping(params="age")
    public ResponseEntity<List<CharacterDTO>> findCharacterByAge(@Parameter(description = "Filter by age") @RequestParam(value = "age", required = false) Integer age) {
        return new ResponseEntity<>(characterMapper.charactersToCharacterDtos(characterService.findByAge(age)), HttpStatus.OK);
    }

    @GetMapping(params="movie")
    public ResponseEntity<List<CharacterDTO>> findCharacterByMovieId(@Parameter(description = "Filter by MovieID") @RequestParam(value = "movie", required = false) Long movieId) {
        return new ResponseEntity<>(characterMapper.charactersToCharacterDtos(characterService.findByMovieId(movieId)), HttpStatus.OK);
    }

    
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteCharacterById(@PathVariable("id") Long id) {
        characterService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @PostMapping()
    public ResponseEntity<CharacterDTO> saveCharacter(@Valid @RequestBody CharacterDTO character) {
        Character characterCreated = characterService.save(characterMapper.characterDtoToCharacter(character));
        return new ResponseEntity<>(characterMapper.characterToCharacterDto(characterCreated), HttpStatus.CREATED);
    }

    
    @PatchMapping("/{id}")
    public ResponseEntity<CharacterDTO> updateCharacter(@Valid @RequestBody CharacterDTO character, @PathVariable("id") Long id) {
        Character characterUpdated = characterService.save(characterMapper.updateCharacterFromDTO(character, characterService.findById(id)));
        return new ResponseEntity<>(characterMapper.characterToCharacterDto(characterUpdated), HttpStatus.OK);
    }

    
    @GetMapping("{id}/movies")
    public ResponseEntity<List<MovieSlimDTO>> getCharacterMovies(@PathVariable("id") Long characterId) {
        return new ResponseEntity<>(movieMapper.moviesToMovieSlimDtos(new ArrayList<>(characterService.findById(characterId).getMovies())), HttpStatus.OK);
    }

    
    @PutMapping("{id}/movies")
    public ResponseEntity<?> addMoviesToCharacter(@Valid @RequestBody ListOfLongDTO moviesIds, @PathVariable("id") Long characterId) {
        characterService.addMovies(characterId, moviesIds.getList());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    
    @DeleteMapping("{id}/movies")
    public ResponseEntity<?> removeMoviesFromCharacter(@Valid @RequestBody ListOfLongDTO moviesIds, @PathVariable("id") Long characterId) {
        characterService.removeMovies(characterId, moviesIds.getList());
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
