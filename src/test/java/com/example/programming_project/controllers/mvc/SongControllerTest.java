package com.example.programming_project.controllers.mvc;

import com.example.programming_project.controllers.api.dtos.NewSongDTO;
import com.example.programming_project.domain.Song;
import com.example.programming_project.domain.SongGenres;
import com.example.programming_project.repository.SongRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.user;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class SongControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private SongRepository songRepository;
    @Autowired
    private ObjectMapper mapper;

    @BeforeAll
    public void setup() {
        songRepository.save(new Song("Don’t Look Back In Anger", 5, SongGenres.rock));
        songRepository.save(new Song("Gunga Din", 3, SongGenres.alternative));
        songRepository.save(new Song("Pet Cemetery", 3, SongGenres.punk));
    }


//    @Test
//    @WithUserDetails("Alexia")
//    public void addSongShouldSucceedAsAdmin() throws Exception {
//        mockMvc.perform(post("/api/songs")
//                .accept(MediaType.APPLICATION_JSON)
//                .contentType(MediaType.APPLICATION_JSON)
//                .content(mapper.writeValueAsString(new NewSongDTO("Sometimes always", 2, SongGenres.alternative))))
//                .andExpect(status().isCreated())
//                .andExpect(header().string(HttpHeaders.CONTENT_TYPE,
//                        MediaType.APPLICATION_JSON.toString()))
//                .andExpect(jsonPath("id", greaterThan(0)))
//                .andExpect(jsonPath("songName", equalTo("Sometimes always")))
//                .andExpect(jsonPath("duration", equalTo(2)))
//                .andExpect(jsonPath("genre", equalTo(SongGenres.alternative)));
//    }

    @Test
    public void addSongShouldFailForRegularUsers() throws Exception {
        mockMvc.perform(post("/api/songs")
                        .accept(MediaType.APPLICATION_JSON)
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(mapper.writeValueAsString(new NewSongDTO("Sometimes always", 2, SongGenres.alternative)))
                        .with(csrf())
                        .with(user("user").roles("USER")))
                .andExpect(status().isForbidden());
    }
}
