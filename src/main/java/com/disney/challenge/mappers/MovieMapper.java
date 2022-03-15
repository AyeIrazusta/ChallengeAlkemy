/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.mappers;

import com.disney.challenge.dtos.*;
import com.disney.challenge.entities.*;

import java.util.List;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface MovieMapper  {

    MovieSlimDTO movieToMovieSlimDto(Movie movie);

    MovieDTO movieToMovieDto(Movie movie);

    Movie movieDTOToMovie(MovieDTO movie);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE,
            nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
    Movie updateMovieFromDTO(MovieDTO movieDTO, @MappingTarget Movie movie);

    List<MovieSlimDTO> moviesToMovieSlimDtos(List<Movie> movies);

    List<MovieDTO> moviesToMovieDtos(List<Movie> movies);

    List<GenreSlimDTO> genresToGenreSlimDtos(List<Genre> genres);
}

