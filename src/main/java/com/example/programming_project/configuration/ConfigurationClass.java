package com.example.programming_project.configuration;

import com.example.programming_project.controllers.api.dtos.AlbumDTO;
import com.example.programming_project.controllers.api.dtos.ArtistDTO;
import com.example.programming_project.controllers.api.dtos.SongDTO;
import com.example.programming_project.controllers.api.dtos.UserDTO;
import com.example.programming_project.domain.Album;
import com.example.programming_project.domain.Artist;
import com.example.programming_project.domain.Song;
import com.example.programming_project.domain.User;
import org.modelmapper.AbstractConverter;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;

@Configuration
@EnableAsync
public class ConfigurationClass {
    @Bean
    public ModelMapper modelMapper() {
        var modelMapper = new ModelMapper();
//artist
        Converter<Artist, ArtistDTO> artistDtoConverter = new AbstractConverter<>() {
            @Override
            protected ArtistDTO convert(Artist source) {
                if (source == null)
                    return null;

                ArtistDTO artist = new ArtistDTO();
                artist.setId(source.getId());
                artist.setName(source.getName());
                artist.setGender(source.getGender());
                artist.setDebutYear(source.getDebutYear());
                return artist;
            }
        };
//album
        Converter<Album, AlbumDTO> albumDTOConverter = new AbstractConverter<>() {
            @Override
            protected AlbumDTO convert(Album source) {
                if (source == null)
                    return null;

                AlbumDTO album = new AlbumDTO();
                album.setId(source.getId());
                album.setTitle(source.getTitle());
                album.setAmountOfSongs(source.getAmountOfSongs());
                album.setReleaseDate(source.getReleaseDate());
                return album;
            }
        };
//songs
        Converter<Song, SongDTO> songDTOConverter = new AbstractConverter<>() {
            @Override
            protected SongDTO convert(Song source) {
                if (source == null)
                    return null;

                SongDTO song = new SongDTO();
                song.setId(source.getId());
                song.setSongName(source.getSongName());
                song.setDuration(source.getDuration());
                song.setGenre(source.getGenre());
                return song;
            }
        };

//users
        Converter<User, UserDTO> userDTOConverter = new AbstractConverter<>() {
            @Override
            protected UserDTO convert(User source) {
                if (source == null)
                    return null;

                UserDTO user = new UserDTO();
                user.setUsername(source.getUsername());
                user.setPassword(source.getPassword());
                return user;
            }
        };

        modelMapper.addConverter(artistDtoConverter);
        modelMapper.addConverter(albumDTOConverter);
        modelMapper.addConverter(songDTOConverter);
        modelMapper.addConverter(userDTOConverter);
        return modelMapper;
    }
}
