package com.example.programming_project.controllers.mvc.viewModels;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.List;

@ToString
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AlbumViewModel {
    private long id;
    @NotBlank
    private String title;
    private int amountOfSongs;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate releaseDate;
    private List<SongViewModel> songs;

    public AlbumViewModel(long id, String title, int amountOfSongs, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.amountOfSongs = amountOfSongs;
        this.releaseDate = releaseDate;
    }
}
