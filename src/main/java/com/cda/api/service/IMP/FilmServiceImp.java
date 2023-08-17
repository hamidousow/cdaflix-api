package com.cda.api.service.IMP;

import com.cda.api.model.Film;
import com.cda.api.repository.FilmRepository;
import com.cda.api.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImp implements IFilmService {
    @Autowired
    private FilmRepository filmRepository;

    EntityManager em;

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

    @Override
    public List<Film> findByTitreLike(String titre) {
        return filmRepository.findByTitreContainsIgnoreCase(titre);
    }

    @Override
    public List<Film> findAllByTitreLikeIgnoreCase(String titre) {
        return filmRepository.findAllByTitreLikeIgnoreCase("%titre%");
    }

}
