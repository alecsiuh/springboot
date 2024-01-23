package com.example.programming_project.domain;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    @Column(name = "amountofsongs", length = 3)
    private int amountOfSongs;
    @Column(name = "releasedate", length = 10)
    private LocalDate releaseDate;
    @ManyToMany
    private transient List<Song> songs = new ArrayList<>();

    @ManyToOne
    private User admin;

    @ManyToOne
    @JoinColumn(name = "artistid")
    private Artist artist;

    public Album(long id, String title, int amountOfSongs, LocalDate releaseDate) {
        this.id = id;
        this.title = title;
        this.amountOfSongs = amountOfSongs;
        this.releaseDate = releaseDate;
    }

    public Album(String title, int amountOfSongs, LocalDate releaseDate, User admin) {
        this.title = title;
        this.amountOfSongs = amountOfSongs;
        this.releaseDate = releaseDate;
        this.admin = admin;
    }

    public Album(String title, int amountOfSongs, LocalDate releaseDate) {
        this.title = title;
        this.amountOfSongs = amountOfSongs;
        this.releaseDate = releaseDate;
    }
}
