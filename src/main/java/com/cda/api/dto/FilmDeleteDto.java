package com.cda.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.mapstruct.Mapping;

@NoArgsConstructor
@AllArgsConstructor
public class FilmDeleteDto {

    @JsonProperty("_utilisateur")
    private UtilisateurCoDto utilisateurCoDto;


    @JsonProperty("_idFilm")
    private Integer idFilm;

    public UtilisateurCoDto getUtilisateurCoDto() {
        return utilisateurCoDto;
    }

    public void setUtilisateurCoDto(UtilisateurCoDto utilisateurCoDto) {
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
