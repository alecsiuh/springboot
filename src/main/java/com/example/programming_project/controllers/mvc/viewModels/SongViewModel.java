package com.example.programming_project.controllers.mvc.viewModels;

import com.example.programming_project.domain.SongGenres;
import lombok.*;

import javax.validation.constraints.NotBlank;
@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SongViewModel {
    private long id;
    @NotBlank
    private String songName;

    private int duration;
    private SongGenres genre;
}
