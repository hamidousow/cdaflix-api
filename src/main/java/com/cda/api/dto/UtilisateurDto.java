package com.cda.api.dto;

import com.cda.api.model.Film;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class UtilisateurDto implements Serializable {
    @JsonProperty("_email")
    private String email;
    @JsonProperty("_password")
    private String motDePasse;

    @JsonProperty("_films_fav")
    private List<FilmDto> filmsFavoris;

    /**
     * Gets email.
     *
     * @return value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email value of email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets motDePasse.
     *
     * @return value of motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Sets motDePasse.
     *
     * @param motDePasse value of motDePasse
     */
    public void setMotDePasse(final String motDePasse) {
        this.motDePasse = motDePasse;
    }

    public List<FilmDto> getFilmsFavoris() {
        return filmsFavoris;
    }

    public void setFilmsFavoris(List<FilmDto> filmsFavoris) {
        this.filmsFavoris = filmsFavoris;
    }
}
