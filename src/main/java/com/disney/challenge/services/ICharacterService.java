/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.services;

import com.disney.challenge.entities.Character;

import java.util.List;

public interface ICharacterService {

    List<Character> getAll();

    Character findById(Long characterId);

    List<Character> findByName(String name);

    List<Character> findByAge(Integer age);

    void delete(Long id);

    Character save(Character character);

    List<Character> findByMovieId(Long idMovie);

    void addMovies(Long characterId, List<Long> moviesIds);

    void removeMovies(Long characterId, List<Long> moviesIds);

}

