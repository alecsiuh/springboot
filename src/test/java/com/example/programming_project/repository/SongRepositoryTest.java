package com.example.programming_project.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import com.example.programming_project.domain.Song;
import com.example.programming_project.domain.SongGenres;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SongRepositoryTest {
    @Autowired
    private SongRepository songRepository;
    boolean expectedOutcome = true;
    long songId;

    @BeforeAll
    public void setup() {
        var hawaii = songRepository.save(new Song("Hawaii", 4, SongGenres.rock));
        songId = hawaii.getId();
    }

    @Test
    public void findSongByNameIsCaseInsensitive() {
        if (expectedOutcome) {
            var song1 = songRepository.findSongByName("Hawaii");
            var song2 = songRepository.findSongByName("hAWaiI");
            var song3 = songRepository.findSongByName("HawaII");

            assertEquals(1, song1.size());
            assertEquals("Hawaii", song1.get(0).getSongName());
            assertEquals(1, song2.size());
            assertEquals("Hawaii", song2.get(0).getSongName());
            assertEquals(1, song3.size());
            assertEquals("Hawaii", song3.get(0).getSongName());
            Assertions.assertTrue(true, "Test passed!");
        } else {
            Assertions.fail("Test failed!");
        }
    }

    @AfterAll
    public void teardown() {
        songRepository.deleteById(songId);
    }
}
