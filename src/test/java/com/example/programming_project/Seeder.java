package com.example.programming_project;

import com.example.programming_project.domain.Song;
import com.example.programming_project.domain.SongGenres;
import com.example.programming_project.repository.SongRepository;
import org.junit.jupiter.api.BeforeAll;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
@Profile("strategy2")
public class Seeder {
    private static SongRepository songRepository;

    public Seeder(SongRepository songRepository) {
        Seeder.songRepository = songRepository;

        seed();
    }

    @BeforeAll
    public static void seed() {
        songRepository.save(new Song("Don’t Look Back In Anger", 5, SongGenres.rock));
        songRepository.save(new Song("Gunga Din", 3, SongGenres.alternative));
        songRepository.save(new Song("Pet Cemetery", 3, SongGenres.punk));
    }
}
