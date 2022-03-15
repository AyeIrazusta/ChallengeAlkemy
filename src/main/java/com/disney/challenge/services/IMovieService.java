/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.services;

import com.disney.challenge.dtos.MovieDTO;
import  com.disney.challenge.entities.*;

import java.util.List;
import java.util.Set;

public interface IMovieService {

    List<Movie> getAll();

    List<Movie> findAllOrderByCreationDate(String order);

    Movie findById(Long movieId);

    List<Movie> findByTitle(String title);

    void delete(Long id);

    Movie save(Movie movie);

    List<Movie> findByGenreId(Long idGenre);

    Set<Genre> getGenres(Long id);

    void addGenres(Long movieId, List<Long> genresIds);

    void removeGenres(Long movieId, List<Long> genresIds);
    
    List<MovieDTO> returnEmptyMovieDto();

}

