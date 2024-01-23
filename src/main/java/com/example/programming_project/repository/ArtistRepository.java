package com.example.programming_project.repository;

import com.example.programming_project.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    @Query("select artist from Artist artist where upper(artist.name) like upper(concat('%', :searchValue, '%'))")
    List<Artist> findArtistByName(@Param("searchValue") String searchValue);
}
