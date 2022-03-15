/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.dtos;

import com.disney.challenge.entities.Movie;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Set;


@Getter
@Setter
public class CharacterDTO {

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "El nombre no puede estar en blanco")
    private String name;

    @NotBlank(message = "ImageURL no puede estar en blanco")
    private String image;

    @NotNull
    private Integer age;

    @NotNull
    private Float weight;

    @NotBlank(message = "La historia no puede estar en blanco")
    private String history;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Set<Movie> movies;

    
}

