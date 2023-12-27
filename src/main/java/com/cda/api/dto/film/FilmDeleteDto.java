package com.cda.api.dto.film;

import com.cda.api.dto.user.UserDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class FilmDeleteDto {

    @JsonProperty("utilisateur")
    private UserDto utilisateurCoDto;


    @JsonProperty("idFilm")
    private Integer idFilm;

    public UserDto getUtilisateurCoDto() {
        return utilisateurCoDto;
    }

    public void setUtilisateurCoDto(UserDto utilisateurCoDto) {
        this.utilisateurCoDto = utilisateurCoDto;
    }

    public Integer getIdFilm() {
        return idFilm;
    }

    public void setIdFilm(Integer idFilm) {
        this.idFilm = idFilm;
    }

    @Override
    public String toString() {
        return "FilmDeleteDto{" +
                "utilisateurCoDto=" + utilisateurCoDto +
                ", idFilm=" + idFilm +
                '}';
    }
}
