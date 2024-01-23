package com.example.programming_project.controllers.api;

import com.example.programming_project.service.ArtistService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.times;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.mockito.Mockito.verify;

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@AutoConfigureMockMvc
@SpringBootTest
class ArtistsControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private ArtistService artistService;

    @Test
    public void searchArtistsShouldSearchCaseInsensitive() throws Exception {
        mockMvc.perform(get("/api/artists")
                        .queryParam("searchValue", "the")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(header().string(HttpHeaders.CONTENT_TYPE,
                        MediaType.APPLICATION_JSON.toString()))
                .andExpect(jsonPath("$.length()", equalTo(1)))
                .andExpect(jsonPath("$[0].name", equalTo("The Strokes")));
    }

    @Test
    @WithMockUser
    public void deleteArtistShouldReturnNotFoundForNonExistingArtist() throws Exception {
        var artistId = 789987L;
        given(artistService.artistExists(artistId)).willReturn(false);

        mockMvc.perform(delete("/api/artist/{artistId}", artistId)
                        .with(csrf()))
                .andExpect(status().isNotFound());
        verify(artistService, times(0)).removeArtist(anyLong());
    }
}
