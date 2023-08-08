package com.cda.api.repository;


import com.cda.api.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {
    Film findFilmById(Integer idFilm);
    void delete(Film film);

    Film findByTitre(String titre);

    List<Film> findAllByTitre(String titre);

    /*@Query("SELECT film from Film film WHERE film.titre IN :titre")
    List<Film> findAllByTitreIn(List<String> titre);*/

    //List<Film> findAllByTitreLike(String titre);

    List<Film> findAllByTitreLikeIgnoreCase(String s);
}
