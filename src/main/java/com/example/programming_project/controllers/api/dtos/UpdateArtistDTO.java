package com.example.programming_project.controllers.api.dtos;

import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UpdateArtistDTO {
    @NotBlank
    private String name;
}
