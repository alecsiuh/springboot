package com.example.programming_project.controllers.api;

import com.example.programming_project.controllers.api.dtos.ArtistDTO;
import com.example.programming_project.controllers.api.dtos.NewArtistDTO;
import com.example.programming_project.controllers.api.dtos.UpdateArtistDTO;
import com.example.programming_project.domain.Artist;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.security.AdminOnly;
import com.example.programming_project.security.CustomUserDetails;
import com.example.programming_project.service.ArtistService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/artists")
@Validated
public class ArtistsController {
    private final ArtistService artistService;
    private final ModelMapper modelMapper;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());
    @GetMapping("/artists")
    public ResponseEntity<List<Artist>> getArtists(){
        LOGGER.info("ArtistsController is running getArtists");
        return ResponseEntity.ok(artistService.getAllArtists());
    }

    @PostMapping
    @AdminOnly
    public ResponseEntity<ArtistDTO> addArtist(
            @RequestBody @Valid NewArtistDTO artistDTO,
            @AuthenticationPrincipal CustomUserDetails user) {
        LOGGER.info("ArtistsController is running addArtist");
        try {
            Artist createdArtist = artistService.addArtist(
                    artistDTO.getName(),
                    artistDTO.getGender(),
                    artistDTO.getDebutYear(),
                    user.getUserId());
            return new ResponseEntity<>(
                    new ArtistDTO(
                            createdArtist.getId(),
                            createdArtist.getName(),
                            createdArtist.getGender(),
                            createdArtist.getDebutYear()),
                    HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UpdateArtistDTO> updateArtist(@PathVariable("id") long id, @Valid @RequestBody UpdateArtistDTO artistDTO) {
        LOGGER.info("ArtistsController is running updateArtist");
        if (artistService.updateArtist(id, artistDTO.getName())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<ArtistDTO>> searchArtists(@RequestParam String searchValue) {
        LOGGER.info("ArtistsController is running searchArtist");
        var artists = artistService.searchArtists(searchValue);
        if (artists.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(
                    artists.stream().map(artist -> new ArtistDTO(
                            artist.getId(), artist.getName(), artist.getGender(), artist.getDebutYear()
                    )).toList(),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("{id}")
    @AdminOnly
    public ResponseEntity<HttpStatus> deleteArtist(@PathVariable("id") long id) {
        LOGGER.info("ArtistsController is running deleteArtist");
        if (artistService.artistExists(id)) {
            artistService.removeArtist(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
