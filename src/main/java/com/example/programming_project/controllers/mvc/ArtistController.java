package com.example.programming_project.controllers.mvc;

import com.example.programming_project.controllers.mvc.viewModels.ArtistViewModel;
import com.example.programming_project.service.ArtistCsvService;
import com.example.programming_project.service.ArtistService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@AllArgsConstructor
@Controller
public class ArtistController {
    private final ArtistService artistService;
    private final ArtistCsvService artistCsvService;

    @GetMapping("/artists")
    public ModelAndView allArtists() {
        var mav = new ModelAndView();
        mav.setViewName("artists");
        mav.addObject("allArtists",
                artistService.getAllArtists()
                        .stream()
                        .map(artist -> new ArtistViewModel(
                                artist.getId(),
                                artist.getName(),
                                artist.getGender(),
                                artist.getDebutYear()))
                        .toList());
        return mav;
    }

    @GetMapping("/addArtist")
    public ModelAndView addArtist() {
        var mav = new ModelAndView();
        mav.setViewName("addArtist");
        return mav;
    }

    @GetMapping("artists/artist/{id}")
    public ModelAndView showOneArtist(@PathVariable long id) {
        var artist = artistService.getArtist(id);
        var mav = new ModelAndView();
        mav.setViewName("artist");
        mav.addObject("artist", new ArtistViewModel(
                artist.getId(),
                artist.getName(),
                artist.getGender(),
                artist.getDebutYear()));
        return mav;
    }


    @GetMapping("/artists_csv")
    public ModelAndView uploadCsv() {
        var mav = new ModelAndView();
        mav.setViewName("artists_csv");
        mav.getModel().put("inProgress", false);
        return mav;
    }

    @PostMapping("/artists_csv")
    public ModelAndView uploadCsv(@RequestParam("artists_csv") MultipartFile file) throws IOException {
        artistCsvService.processCsv(file.getInputStream());

        var mav = new ModelAndView();
        mav.setViewName("artists_csv");
        mav.getModel().put("inProgress", true);
        return mav;
    }
}
