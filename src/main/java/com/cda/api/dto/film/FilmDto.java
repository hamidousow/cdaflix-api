package com.cda.api.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.Duration;

public class FilmDto {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;


    @JsonProperty("actors")
    private String actors;

    @JsonProperty("img")
    private String img;

    public FilmDto() {
    }

    public FilmDto(String titre, String description, String actors, String imgName) {
        this.title = titre;
        this.description = description;
        this.actors = actors;
        this.img = imgName;
    }

    public FilmDto(Integer id, String titre, String description, String actors) {
        this.id = id;
        this.title = titre;
        this.description = description;
        this.actors = actors;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getActors() {
        return actors;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public void setActors(String actors) {
        this.actors = actors;
    }
}
