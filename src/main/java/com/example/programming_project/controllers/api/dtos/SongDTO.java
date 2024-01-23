package com.example.programming_project.controllers.api.dtos;

import com.example.programming_project.domain.SongGenres;
import lombok.*;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongDTO {
    private long id;
    private String songName;
    private int duration;
    private SongGenres genre;
}
