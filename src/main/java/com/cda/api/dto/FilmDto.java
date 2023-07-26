package com.cda.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.sql.Timestamp;
import java.time.Duration;


@NoArgsConstructor
@AllArgsConstructor
public class FilmDto {

    @JsonProperty("_id")
    private Integer id;

    @JsonProperty("_titre")
    private String titre;

    @JsonProperty("_description")
    private String description;

    @JsonProperty("_duree")
    private Timestamp duree;
    @JsonProperty("_img")
    private String img;

    private byte[] imgBytes;

    public void setImg(String img) {
        this.img = img;
    }

    public byte[] getImgBytes() {
        return imgBytes;
    }

    public void setImgBytes(byte[] imgBytes) {
        this.imgBytes = imgBytes;
    }

    public String getImg() {
        return img;
    }

    @JsonProperty("_acteurs")
    private String acteurs;

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


    public Timestamp getDuree() {
        return duree;
    }

    public void setDuree(Timestamp duree) {
        this.duree = duree;
    }

    public String getActeurs() {
        return acteurs;
    }

    public void setActeurs(String acteurs) {
        this.acteurs = acteurs;
    }

    @Override
    public String toString() {
        return "FilmDto {" +
                "titre='" + titre + '\'' +
                ", description='" + description + '\'' +
                ", duree='" + duree + '\'' +
                ", img='" + img + '\'' +
                ", acteurs='" + acteurs + '\'' +
                '}';
    }


}
