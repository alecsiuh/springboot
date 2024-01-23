package com.example.programming_project.controllers.api;

import com.example.programming_project.controllers.api.dtos.AlbumDTO;
import com.example.programming_project.controllers.api.dtos.NewAlbumDTO;
import com.example.programming_project.controllers.api.dtos.UpdateAlbumDTO;
import com.example.programming_project.domain.Album;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.security.AdminOnly;
import com.example.programming_project.security.CustomUserDetails;
import com.example.programming_project.service.AlbumService;
import lombok.AllArgsConstructor;
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
@RequestMapping("/api/albums")
@Validated
public class AlbumsController {
    private final AlbumService albumService;
    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/albums")
    public ResponseEntity<List<Album>> getAlbums() {
        return ResponseEntity.ok(albumService.getAllAlbums());
    }
    @PostMapping
    public ResponseEntity<AlbumDTO> addAlbum(
            @RequestBody @Valid NewAlbumDTO albumDTO) {
        LOGGER.info("AlbumsController is running addAlbum");
        try {
            Album createdAlbum = albumService.addClientAlbum(
                    albumDTO.getTitle(),
                    albumDTO.getAmountOfSongs(),
                    albumDTO.getReleaseDate());
            return new ResponseEntity<>(
                    new AlbumDTO(
                            createdAlbum.getId(),
                            createdAlbum.getTitle(),
                            createdAlbum.getAmountOfSongs(),
                            createdAlbum.getReleaseDate()),
                    HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UpdateAlbumDTO> updateAlbum(@PathVariable("id") long id, @Valid @RequestBody UpdateAlbumDTO albumDTO) {
        LOGGER.info("AlbumsController is running updateAlbum");
        if (albumService.updateAlbum(id, albumDTO.getTitle())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<AlbumDTO>> searchAlbums(@RequestParam String searchValue) {
        var albums = albumService.searchAlbums(searchValue);
        if (albums.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(
                    albums.stream().map(album -> new AlbumDTO(
                            album.getId(), album.getTitle(), album.getAmountOfSongs(), album.getReleaseDate()
                    )).toList(),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("{id}")
    @AdminOnly
    public ResponseEntity<Void> deleteAlbum(@PathVariable("id") long id) {
        if (albumService.albumExists(id)) {
            albumService.removeAlbum(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
