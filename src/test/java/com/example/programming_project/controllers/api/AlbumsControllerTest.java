package com.example.programming_project.controllers.api;

import com.example.programming_project.service.AlbumService;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class AlbumsControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void searchAlbumsShouldSearchCaseInsensitive() throws Exception {
        mockMvc.perform(get("/api/albums")
                        .queryParam("searchValue", "the")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON.toString()))
                .andExpect(jsonPath("$.length()", equalTo(4)))
                .andExpect(jsonPath("$[0].title", equalTo("The New Abnormal")))
                .andExpect(jsonPath("$[0].amountOfSongs", equalTo(10)))
                .andExpect(jsonPath("$[0].releaseDate", equalTo("2020-04-10")))
                .andExpect(jsonPath("$[1].title", equalTo("The Bends")))
                .andExpect(jsonPath("$[1].amountOfSongs", equalTo(12)))
                .andExpect(jsonPath("$[1].releaseDate", equalTo("1995-03-13")))
                .andExpect(jsonPath("$[2].title", equalTo("What We Saw from the Cheap Seats")))
                .andExpect(jsonPath("$[2].amountOfSongs", equalTo(11)))
                .andExpect(jsonPath("$[2].releaseDate", equalTo("2012-05-25")))
                .andExpect(jsonPath("$[3].title", equalTo("Either/Or")))
                .andExpect(jsonPath("$[3].amountOfSongs", equalTo(12)))
                .andExpect(jsonPath("$[3].releaseDate", equalTo("1997-02-25")))
                .andExpect(jsonPath("$[*].title", Matchers.contains("The New Abnormal", "The Bends", "What We Saw from the Cheap Seats", "Either/Or")));
    }
}
