package com.example.programming_project.controllers.api.dtos;


import lombok.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AlbumDTO {
    private long id;
    private String title;
    private int amountOfSongs;
    private LocalDate releaseDate;
}
