package com.example.programming_project.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.programming_project.domain.Artist;
import com.example.programming_project.domain.User;
import com.example.programming_project.domain.UserRole;
import com.example.programming_project.repository.ArtistRepository;
import com.example.programming_project.repository.UserRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class ArtistServiceTest {
    @Autowired
    private ArtistService artistService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ArtistRepository artistRepository;
    boolean expectedOutcome = true;
    private long artistID;

    @BeforeAll
    public void setup() {
        var user = userRepository.save(new User("Jake", "$2a$12$nW0O3T2RbBN8GSGpO9GxhOn5KWXy67yXzjio0Lb73s0rjTuikhv0m", "jakeK@gmail.com", UserRole.USER));
        var artist = artistRepository.save(new Artist("The Voids", "male group", 2014, user));
        artistID = artist.getId();
    }

    @Test
    void changeArtistNameShouldChangeTheArtistName() {
        if(expectedOutcome){
            var changedSuccessfully = artistService.updateArtist(artistID, "The Voidz");
            var voidz = artistRepository.findById(artistID).get();
            assertEquals("The Voidz", voidz.getName());
            assertTrue(changedSuccessfully);
            Assertions.assertTrue(true, "Test passed!");
        }else {
            Assertions.fail("Test failed!");
        }

    }
}
