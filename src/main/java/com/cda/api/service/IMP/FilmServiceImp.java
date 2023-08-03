package com.cda.api.service.IMP;

import com.cda.api.model.Film;
import com.cda.api.repository.FilmRepository;
import com.cda.api.service.IFilmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FilmServiceImp implements IFilmService {
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
