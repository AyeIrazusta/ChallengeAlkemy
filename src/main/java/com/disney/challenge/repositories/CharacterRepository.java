/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.repositories;

import com.disney.challenge.entities.Character;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CharacterRepository extends JpaRepository<Character, Long> {

    Optional<Character> findById(Long id);

    List<Character> findByName(String name);

    List<Character> findByAge(Integer age);

    List<Character> findByMoviesId(Long id);

    

}