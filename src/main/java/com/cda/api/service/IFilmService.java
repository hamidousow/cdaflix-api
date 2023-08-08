package com.cda.api.service;

import com.cda.api.model.Film;

import java.util.List;

public interface IFilmService {
    Film findById(Integer idFilm);

    List<Film> getAll();

    void save(Film film);

    void delete(Film film);

    Film findByTitre(String titre);

    List<Film> findAllByTitreLikeIgnoreCase(String titre);

    //List<Film> findAllByTitreIn(List<String> titre);
}
