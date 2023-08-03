package com.cda.api.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.Duration;

public class FilmDto {

    @JsonProperty("_id")
    private Integer id;

    @JsonProperty("_titre")
    private String titre;

    @JsonProperty("_description")
    private String description;
    @JsonProperty("_img")
    private String imgPath;

    @JsonProperty("_actors")
    private String actors;

    public FilmDto() {
    }

    public FilmDto(String titre, String description, String imgPath) {
        this.titre = titre;
        this.description = description;
        this.imgPath = imgPath;
    }

    public FilmDto(String titre, String description, String imgPath, String actors) {
        this.titre = titre;
        this.description = description;
        this.imgPath = imgPath;
        this.actors = actors;
    }

    public String getActors() {
        return actors;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public void setImg(String img) {
        this.imgPath = img;
    }

    public String getImg() {
        return imgPath;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return "FilmDto{" +
                "id=" + id +
                ", titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", imgPath='" + imgPath + '\'' +
                ", actors='" + actors + '\'' +
                '}';
    }
}
