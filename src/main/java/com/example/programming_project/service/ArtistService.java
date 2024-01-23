package com.example.programming_project.service;

import com.example.programming_project.domain.Artist;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.repository.ArtistRepository;
import com.example.programming_project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
@AllArgsConstructor
@Service
public class ArtistService {
    private final ArtistRepository artistRepository;
    private final UserRepository userRepository;

    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    public Artist addArtist(String name, String gender, int debutYear, long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID '" + userId + "' not found!"));
        var artist = new Artist(name, gender, debutYear, user);
        return artistRepository.save(artist);
    }

    public boolean updateArtist(long artistId, String newName) {
        var artist = artistRepository.findById(artistId).orElse(null);
        if (artist == null) {
            return false;
        }
        artist.setName(newName);
        artistRepository.save(artist);
        return true;
    }

    public Artist getArtist(long id) {
        return artistRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public List<Artist> searchArtists(String searchValue) {
        return artistRepository.findArtistByName(searchValue);
    }

    public void removeArtist(long id) {
        artistRepository.deleteById(id);
    }
    public boolean artistExists(long id) {
        return artistRepository.existsById(id);
    }
}
