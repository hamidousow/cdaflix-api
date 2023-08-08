package com.cda.api.mapper;


import com.cda.api.dto.film.FilmDeleteDto;
import com.cda.api.dto.film.FilmDto;
import com.cda.api.model.Film;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring", unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface FilmMapper {

    Film filmDtoToFilm(FilmDto filmDto);

    FilmDto filmToFilmDto(Film film);

    @Mapping(source = "idFilm", target = "id")
    Film filmDeleteDtoToFilm(FilmDeleteDto filmDeleteDto);

    List<FilmDto> filmsToFilmsDto(List<Film> films);
}
