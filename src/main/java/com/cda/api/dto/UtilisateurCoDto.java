package com.cda.api.dto;

import com.cda.api.model.Film;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class UtilisateurCoDto {

    @JsonProperty("_idUtilisateur")
    private Integer id;

    @JsonProperty("_email")
    private String email;

    @JsonProperty("_films_fav")
    private List<FilmDto> filmsFavoris;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<FilmDto> getFilmsFavoris() {
        return filmsFavoris;
    }

    public void setFilmsFavoris(List<FilmDto> filmsFavoris) {
        this.filmsFavoris = filmsFavoris;
    }


}
