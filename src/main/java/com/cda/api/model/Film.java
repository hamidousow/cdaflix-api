package com.cda.api.model;

import lombok.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Duration;
import java.util.List;

@Entity
@Table(name = "T_FILM_FLM", schema = "cdaflix")
@Component
public class Film {

    @Id
    @SequenceGenerator(name = "flm_id_seq_gen", sequenceName = "cdaflix.t_film_flm_flm_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flm_id_seq_gen")
    @Column(name = "FLM_ID")
    private Integer id;

    @Column(name = "FLM_TITLE")
    private String title;

    @Column(name = "FLM_DESCRIPTION")
    private String description;

    //TODO: à remplacer par une liste d'acteur
    @Column(name = "FLM_ACTORS")
    private String actors;

    @Column(name= "FLM_IMG")
    private String img;

    public Film() {
    }

    public Film(String title, String description, String imgPath) {
        this.title = title;
        this.description = description;
        this.img = img;
    }

    public Film(String title, String description, String img, String actors) {
        this.title = title;
        this.description = description;
        this.img = img;
        this.actors = actors;
    }

    public String getActeurs() {
        return actors;
    }

    public void setActeurs(String acteurs) {
        this.actors = acteurs;
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

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public void setActors(String actors) {
        this.actors = actors;
    }


    @Override
    public String toString() {
        return "Film {" +
                "titre ='" + title + '\'' +
                ", description ='" + description + '\'' +
                ", img ='" + img + '\'' +
                ", acteurs ='" + actors + '\'' +
                '}';
    }
}
