package com.example.programming_project.controllers.mvc;

import com.example.programming_project.controllers.mvc.viewModels.AlbumViewModel;
import com.example.programming_project.controllers.mvc.viewModels.SongViewModel;
import com.example.programming_project.service.AlbumService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

@AllArgsConstructor
@Controller
public class AlbumController {
    private final AlbumService albumService;

    @GetMapping("/albums")
    public ModelAndView allAlbums() {
        var mav = new ModelAndView();
        mav.setViewName("albums");
        mav.addObject("allAlbums",
                albumService.getAllAlbums()
                        .stream()
                        .map(album -> new AlbumViewModel(
                                album.getId(),
                                album.getTitle(),
                                album.getAmountOfSongs(),
                                album.getReleaseDate()))
                        .toList());
        return mav;
    }

    @GetMapping("/addAlbum")
    public ModelAndView addAlbum() {
        var mav = new ModelAndView();
        mav.setViewName("addAlbum");
        return mav;
    }

    @GetMapping("albums/album/{id}")
    public ModelAndView showOneAlbum(@PathVariable long id) {
        var album = albumService.getAlbum(id);
        var mav = new ModelAndView();
        mav.setViewName("album");
        mav.addObject("album", new AlbumViewModel(
                album.getId(),
                album.getTitle(),
                album.getAmountOfSongs(),
                album.getReleaseDate(),
                album.getSongs()
                        .stream().map(
                                song ->
                                        new SongViewModel(
                                                song.getId(),
                                                song.getSongName(),
                                                song.getDuration(),
                                                song.getGenre()
                                        )
                        ).toList()
        ));
        return mav;
    }
}
