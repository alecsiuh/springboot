package com.example.programming_project.repository;

import com.example.programming_project.domain.Artist;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class ArtistRepositoryTest {
    @Autowired
    private ArtistRepository artistRepository;
    boolean expectedOutcome = true;

    @Test
    void artistNameIsUnique() {
        if (expectedOutcome) {
            var artist1 = new Artist("Bladee", "male artist", 2012);
            artistRepository.save(artist1);
            assertThrows(DataIntegrityViolationException.class, () -> {
                var artist2 = new Artist("Bladee", "male artist", 2012);
                artistRepository.save(artist2);
            });
            Assertions.assertTrue(true, "Test passed!");
        }else {
            Assertions.assertFalse(false, "Test failed!");
        }
    }

    @Test
    public void artistGenderIsMandatory() {
        if(expectedOutcome){
            var newArtist1 = new Artist("Depeche Mode", "male group", 1980);
            var newArtist2 = new Artist("Pink Floyd", null, 1964);

            var createdArtist = artistRepository.save(newArtist1);

            Assertions.assertTrue(createdArtist.getId() > 0);
            assertThrows(DataIntegrityViolationException.class, () -> artistRepository.save(newArtist2));
            Assertions.assertTrue(true, "Test passed!");
        } else {
            Assertions.fail("Test failed!");
        }
    }
}
