/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.disney.challenge.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    private Long id;

    @NotBlank(message = "Titulo no puede estar en blanco")
    private String title;

    @NotBlank(message = "La imagen no puede estar en blanco")
    private String image;

    @NotNull(message = "La fecha no puede estar en blanco")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private String creationDate;

    @NotNull(message = "La puntuación no puede ser nula")
    @Min(value = 0, message = "La puntuación debe ser mayor o igual a 0")
    @Max(value = 10, message = "La puntuación debe ser menor o igual a 10")
    private Integer score;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<CharacterSlimDTO> characters;

    @JsonProperty(access= JsonProperty.Access.READ_ONLY)
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<GenreSlimDTO> genres;

    
}
