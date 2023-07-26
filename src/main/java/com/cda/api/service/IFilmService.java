package com.cda.api.service;

import com.cda.api.dto.FilmDto;
import com.cda.api.model.Film;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFilmService {
    Film findById(Integer idFilm);

    List<Film> getAll();

    void save(Film film);

    void delete(Film film);

}
