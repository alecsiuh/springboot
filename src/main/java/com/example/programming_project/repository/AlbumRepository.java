package com.example.programming_project.repository;

import com.example.programming_project.domain.Album;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlbumRepository extends JpaRepository<Album, Long> {
    @Query("select album from Album album where upper(album.title) like upper(concat('%', :searchValue, '%'))")
    List<Album> findAlbumByTitle(@Param("searchValue") String searchValue);
    @Query(value = "select album from Album album join Song songs ON album.id=songs.albumId where album.id=?1", nativeQuery = true)
    List<Album> getAlbumWithSongs(long albumId);
}

