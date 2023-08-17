package com.cda.api.repository;


import com.cda.api.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    Film findFilmById(Integer idFilm);
    void delete(Film film);

    List<Film> findByTitreContainsIgnoreCase(String titre);

    List<Film> findAllByTitreLikeIgnoreCase(String s);
}
