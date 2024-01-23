package com.example.programming_project.controllers.mvc;

import com.example.programming_project.controllers.mvc.viewModels.SongViewModel;
import com.example.programming_project.service.SongService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;
@AllArgsConstructor
@Controller
public class SongController {
    private final SongService songService;

    @GetMapping("/songs")
    public ModelAndView allSongs() {
        var mav = new ModelAndView();
        mav.setViewName("songs");
        mav.addObject("allSongs",
                songService.getAllSongs()
                        .stream()
                        .map(song -> new SongViewModel(
                                song.getId(),
                                song.getSongName(),
                                song.getDuration(),
                                song.getGenre()))
                        .toList());
        return mav;
    }

    @GetMapping("/addSong")
    public ModelAndView addSong() {
        var mav = new ModelAndView();
        mav.setViewName("addSong");
        return mav;
    }

    @GetMapping("songs/song/{id}")
    public ModelAndView showOneSong(@PathVariable long id) {
        var mav = new ModelAndView();
        mav.setViewName("song");
        mav.addObject("song", songService.getSong(id));
        return mav;
    }
}
