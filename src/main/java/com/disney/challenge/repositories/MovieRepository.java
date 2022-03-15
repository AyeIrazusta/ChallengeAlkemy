/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.repositories;

import com.disney.challenge.entities.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovieRepository extends JpaRepository<Movie, Long> {

    Optional<Movie> findById(Long id);

    List<Movie> findByTitle(String title);

    List<Movie> findByGenresId(Long genreId);

    List<Movie> findAllByOrderByCreationDateAsc();

    List<Movie> findAllByOrderByCreationDateDesc();

}
