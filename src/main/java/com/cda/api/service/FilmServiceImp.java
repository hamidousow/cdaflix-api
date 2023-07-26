package com.cda.api.service;

import com.cda.api.dto.FilmDto;
import com.cda.api.model.Film;
import com.cda.api.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotNull;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@Service
public class FilmServiceImp implements IFilmService{
    @Autowired
    private FilmRepository filmRepository;


    @Override
    public Film findById(Integer idFilm) {
        return filmRepository.findFilmById(idFilm);
    }

    @Override
    public List<Film> getAll() {
        List<Film> films = new ArrayList<>();
        Iterable<Film> filmIterable = filmRepository.findAll();
        for(Film film: filmIterable) {
            films.add(film);
        }
        return films;
    }

    @Override
    public void save(Film film) {
        filmRepository.save(film);
    }

    @Override
    public void delete(Film film) {
        filmRepository.delete(film);
    }

}
