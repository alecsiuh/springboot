package com.example.programming_project.controllers.api.dtos;

import com.example.programming_project.domain.SongGenres;
import lombok.*;

import javax.validation.constraints.NotBlank;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class NewSongDTO {
    @NotBlank
    private String songName;
    private int duration;
    private SongGenres songGenres;
}
