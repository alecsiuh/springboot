package com.example.programming_project.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.function.BooleanSupplier;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class AlbumServiceTest {
    @Autowired
    private AlbumService albumService;
    boolean expectedOutcome = true;

    @Test
    void changeAlbumNameShouldFailForNonExistentAlbum() {
        if(expectedOutcome){
            var changedSuccessfully = albumService.updateAlbum(1000, "saturation");
            assertFalse(changedSuccessfully);
            Assertions.assertTrue(true, "Test passed!");
        }else{
            Assertions.fail("Test failed!");
        }
    }
}
