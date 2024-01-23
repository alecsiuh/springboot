package com.example.programming_project.controllers.api.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewArtistDTO {
    @NotBlank
    private String name;
    @NotBlank
    private String gender;

    private int debutYear;
}
