package com.example.programming_project.service;

import com.example.programming_project.domain.Song;
import com.example.programming_project.domain.SongGenres;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.repository.SongRepository;
import com.example.programming_project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@AllArgsConstructor
@Service
public class SongService {
    private final SongRepository songRepository;
    private final UserRepository userRepository;

    public List<Song> getAllSongs() {
        return songRepository.findAll();
    }

    public Song addSong(String songName, int duration, SongGenres genre, long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID '" + userId + "' not found!"));
        var song = new Song(songName, duration, genre, user);
        return songRepository.save(song);
    }

    public boolean updateSong(long songId, String newName) {
        var song = songRepository.findById(songId).orElse(null);
        if (song == null) {
            return false;
        }
        song.setSongName(newName);
        songRepository.save(song);
        return true;
    }

    public Song getSong(long id) {
        return songRepository.findById(id).orElseThrow(EntityNotFoundException::new);}
    public void removeSong(long id) {
        songRepository.deleteById(id);
    }

    public List<Song> searchSongs(String searchValue) {
        return songRepository.findSongByName(searchValue);
    }

    public boolean songExists(long id) {
        return songRepository.existsById(id);
    }
}
