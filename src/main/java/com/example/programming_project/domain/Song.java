package com.example.programming_project.domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="song")
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private long id;
    @Column(name = "songname", nullable = false, length = 50)
    private String songName;
    @Column(length = 3)
    private int duration;
    @Enumerated(EnumType. STRING)
    private SongGenres genre;

    @ManyToOne
    private User admin;

    @ManyToMany
    private transient List<Album> albums = new ArrayList<>();

    public Song(String songName, int duration, SongGenres genre, User admin) {
        this.songName = songName;
        this.duration = duration;
        this.genre = genre;
        this.admin = admin;
    }

    public Song(long id, String songName, int duration, SongGenres genre) {
        this.id = id;
        this.songName = songName;
        this.duration = duration;
        this.genre = genre;
    }

    public Song(String songName, int duration, SongGenres genre) {
        this.songName = songName;
        this.duration = duration;
        this.genre = genre;
    }
}
