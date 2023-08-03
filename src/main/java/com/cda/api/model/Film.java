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

    @Column(name = "FLM_TITRE")
    private String titre;

    @Column(name = "FLM_DESCRIPTION")
    private String description;

    @Column(name = "FLM_IMG")
    private String imgPath;

    //TODO: à remplacer par une liste d'acteur
    @Column(name = "FLM_ACTORS")
    private String actors;

    public Film() {
    }

    public Film(String titre, String description, String imgPath) {
        this.titre = titre;
        this.description = description;
        this.imgPath = imgPath;
    }

    public Film(String titre, String description, String imgPath, String actors) {
        this.titre = titre;
        this.description = description;
        this.imgPath = imgPath;
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

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }

    public String getImg() {
        return imgPath;
    }

    public void setImg(String img) {
        this.imgPath = img;
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
                "titre ='" + titre + '\'' +
                ", description ='" + description + '\'' +
                ", img ='" + imgPath + '\'' +
                ", acteurs ='" + actors + '\'' +
                '}';
    }
}
