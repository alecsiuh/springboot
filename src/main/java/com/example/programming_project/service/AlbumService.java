package com.example.programming_project.service;

import com.example.programming_project.domain.Album;
import com.example.programming_project.exceptions.UserNotFoundException;
import com.example.programming_project.repository.AlbumRepository;
import com.example.programming_project.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDate;
import java.util.List;
@AllArgsConstructor
@Service
public class AlbumService {
    private final AlbumRepository albumRepository;
    private final UserRepository userRepository;
    public List<Album> getAllAlbums() {
        return albumRepository.findAll();
    }

    public Album addAlbum(String title, int amountOfSongs, LocalDate releaseDate, long userId) {
        var user = userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User ID '" + userId + "' not found!"));
        var album = new Album(title, amountOfSongs, releaseDate, user);
        return albumRepository.save(album);
    }

    public Album addClientAlbum(String title, int amountOfSongs, LocalDate releaseDate) {
        var album = new Album(title, amountOfSongs, releaseDate);
        return albumRepository.save(album);
    }

    public boolean updateAlbum(long albumId, String newName) {
        var album = albumRepository.findById(albumId).orElse(null);
        if (album == null) {
            return false;
        }
        album.setTitle(newName);
        albumRepository.save(album);
        return true;
    }
    public Album getAlbum(long id) {
        return albumRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }
    public List<Album> searchAlbums(String searchValue) {
        return albumRepository.findAlbumByTitle(searchValue);
    }

    public void removeAlbum(long id) {
        albumRepository.deleteById(id);
    }

    public boolean albumExists(long id) {
        return albumRepository.existsById(id);
    }
    public List<Album> findAlbumAndSongs(long albumId){
        return albumRepository.getAlbumWithSongs(albumId);
    }
}
