package com.cda.api.controller;


import com.cda.api.dto.film.FilmDto;
import com.cda.api.mapper.FilmMapper;
import com.cda.api.model.Film;
import com.cda.api.service.IFileService;
import com.cda.api.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@CrossOrigin("*")
@RequestMapping("/film")
public class FilmController {

    @Autowired
    FilmMapper filmMapper;

    @Autowired
    IFilmService filmService;

    @Autowired
    IFileService fileService;

    @RequestMapping(value = "/createMovie", method = RequestMethod.POST)
    public ResponseEntity<String> uploadFilm(@RequestParam(name = "_titre") String titre,
                                             @RequestParam(name = "_description") String description,
                                             @RequestParam(name = "_actors") String actors,
                                             @RequestParam(name = "_img") MultipartFile file) {

        String imgPath = fileService.upload(file);
        FilmDto filmDto = new FilmDto(titre, description, imgPath, actors);
        Film film = filmMapper.filmDtoToFilm(filmDto);
        filmService.save(film);
        return new ResponseEntity<String>(filmDto.getTitre() + " a bien été ajouté", HttpStatus.CREATED);
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<FilmDto>> allMovies() {
        List<Film> allMovies = filmService.getAll();

        List<FilmDto> allMoviesDto = new ArrayList<>();
        if(allMovies != null) {
            allMoviesDto = allMovies.stream().map(film -> filmMapper.filmToFilmDto(film)).collect(Collectors.toList());
            System.out.println(allMoviesDto.toString() + "\n");
        }
        return ResponseEntity.ok(allMoviesDto);
    }
}
