package com.cda.api.dto.film;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.multipart.MultipartFile;

import java.sql.Timestamp;

public class FilmUploadDto {
    @JsonProperty("_titre")
    private String titre;
    @JsonProperty("_description")
    private String description;
    @JsonProperty("_img")
    private String imgPath;

    private MultipartFile file;

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

    public String getImg() {
        return imgPath;
    }

    public void setImg(String img) {
        this.imgPath = img;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
