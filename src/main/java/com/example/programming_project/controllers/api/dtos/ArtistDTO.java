package com.example.programming_project.controllers.api.dtos;

import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ArtistDTO {
    private long id;
    private String name;
    private String gender;
    private int debutYear;
}
