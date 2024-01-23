package com.example.programming_project.controllers.api;

import com.example.programming_project.controllers.api.dtos.NewSongDTO;
import com.example.programming_project.controllers.api.dtos.SongDTO;
import com.example.programming_project.controllers.api.dtos.UpdateSongDTO;
import com.example.programming_project.domain.Song;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.security.AdminOnly;
import com.example.programming_project.security.CustomUserDetails;
import com.example.programming_project.service.SongService;
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
@RequestMapping("/api/songs")
@Validated
public class SongsController {
    private final SongService songService;
    private final ModelMapper modelMapper;

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @GetMapping("/songs")
    public ResponseEntity<List<Song>> getSongs(){
        return ResponseEntity.ok(songService.getAllSongs());
    }

    @PostMapping
    @AdminOnly
    public ResponseEntity<SongDTO> addSong(
            @RequestBody @Valid NewSongDTO songDTO,
            @AuthenticationPrincipal CustomUserDetails user) {
        try {
            Song createdSong = songService.addSong(
                    songDTO.getSongName(),
                    songDTO.getDuration(),
                    songDTO.getSongGenres(),
                    user.getUserId());
            return new ResponseEntity<>(
                    new SongDTO(
                            createdSong.getId(),
                            createdSong.getSongName(),
                            createdSong.getDuration(),
                            createdSong.getGenre()),
                    HttpStatus.CREATED);
        } catch (UserNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("{id}")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ResponseEntity<UpdateSongDTO> updateSong(@PathVariable("id") long id, @Valid @RequestBody UpdateSongDTO songDTO) {
        LOGGER.info("SongsController is running updateSong");
        if (songService.updateSong(id, songDTO.getSongName())) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> searchSongs(@RequestParam String searchValue) {
        var songs = songService.searchSongs(searchValue);
        if (songs.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(
                    songs.stream().map(song -> new SongDTO(
                            song.getId(), song.getSongName(), song.getDuration(), song.getGenre()
                    )).toList(),
                    HttpStatus.OK
            );
        }
    }

    @DeleteMapping("{id}")
    @AdminOnly
    public ResponseEntity<Void> deleteSong(@PathVariable("id") long id) {
        if (songService.songExists(id)) {
            songService.removeSong(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
