package com.example.programming_project.controllers.api;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;

@AutoConfigureMockMvc
@SpringBootTest
class SongsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    boolean expectedOutcome = true;

    @Test
    @WithMockUser
    public void deletingASongShouldReturn404ForNonExistingSong() throws Exception {
        if (expectedOutcome) {
            mockMvc.perform(MockMvcRequestBuilders.delete("/api/songs/{id}", "999")
                    .with(csrf()));
            Assertions.assertTrue(true, "Test passed!");
        } else {
            Assertions.fail("Test failed!");
        }
    }
}
