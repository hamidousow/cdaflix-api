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
    public ResponseEntity<String> uploadFilm(@RequestParam(name = "title") String titre,
                                             @RequestParam(name = "description") String description,
                                             @RequestParam(name = "actors") String actors,
                                             @RequestParam(name = "img") MultipartFile file
                                             ) {

        String imgPath = fileService.upload(file);
        FilmDto filmDto = new FilmDto(titre, description, actors);
        Film film = filmMapper.filmDtoToFilm(filmDto);
        filmService.save(film);
        return new ResponseEntity<String>(filmDto.getTitle() + " a bien été ajouté", HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<FilmDto>> allMovies() {
        List<Film> allMovies = filmService.getAll();

        List<FilmDto> allMoviesDto = new ArrayList<>();
        if(allMovies != null) {
            allMoviesDto = allMovies.stream().map(film -> filmMapper.filmToFilmDto(film)).collect(Collectors.toList());
        }
        return ResponseEntity.ok(allMoviesDto);
    }
    @GetMapping("/findByTitle")
    public ResponseEntity<List<FilmDto>> findOne(@RequestParam(name = "title") String title) {

        List<Film> films = filmService.findByTitreLike(title);
        if(films != null) {
            List<FilmDto> filmDto = filmMapper.filmsToFilmsDto(films);
            return new ResponseEntity<>(filmDto, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/updateMovie", method = RequestMethod.POST)
    public ResponseEntity<String> updateFilm(@RequestParam("id") Integer idFilm,
                                             @RequestParam(name = "title") String title,
                                             @RequestParam(name = "description") String description,
                                             @RequestParam(name = "actors") String actors,
                                             @RequestParam(name = "img") MultipartFile file) {
        Film film = filmService.findById(idFilm);
        String imgPath = film.getImg();
        if(!file.isEmpty()) {
            imgPath = fileService.upload(file);
        }
        FilmDto filmDto = new FilmDto(idFilm, title, description, actors);
        Film filmUpdated = filmMapper.filmDtoToFilm(filmDto);
        filmService.save(filmUpdated);
        return new ResponseEntity<String>( " Modifications enregistrées", HttpStatus.OK);
    }

    @RequestMapping(value = "/deleteMovie", method = RequestMethod.GET)
    public ResponseEntity<String> deleteFilm(@RequestParam("id") Integer idFilm) {

        Film filmToDelete = filmService.findById(idFilm);
        if(filmToDelete != null) {
            filmService.delete(filmToDelete);
            return new ResponseEntity<String>("Film supprimé", HttpStatus.CREATED);
        }

        //todo: rechercher du film, si result == null confirmé la suppression
        return new ResponseEntity<String>("Id inconnu", HttpStatus.NOT_FOUND);
    }
}
