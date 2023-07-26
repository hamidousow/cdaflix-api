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
    @SequenceGenerator(name = "flm_id_seq_gen", sequenceName = "cda.t_film_flm_flm_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "flm_id_seq_gen")
    @Column(name = "FLM_ID")
    private Integer id;

    @Column(name = "FLM_TITRE")
    private String titre;

    @Column(name = "FLM_DESCRIPTION")
    private String description;

    @Column(name = "FLM_DUREE")
    private Timestamp duree;

    @Column(name = "FLM_IMG")
    private String img;

    @Transient
    private byte[] imgBytes;

    /*@Transient
    @Value("${images.path}")
    private String imgPath;*/

    //TODO: à remplacer par une liste d'acteur
    @Column(name = "FLM_ACTORS")
    private String acteurs;

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
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

    public Timestamp getDuree() {
        return duree;
    }

    public void setDuree(Timestamp duree) {
        this.duree = duree;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public String getActors() {
        return acteurs;
    }

    public void setActors(String actors) {
        this.acteurs = actors;
    }

    @Override
    public String toString() {
        return "Film {" +
                "titre ='" + titre + '\'' +
                ", description ='" + description + '\'' +
                ", duree ='" + duree + '\'' +
                ", img ='" + img + '\'' +
                ", acteurs ='" + acteurs + '\'' +
                '}';
    }
}
