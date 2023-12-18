package com.cda.api.service;

import com.cda.api.dto.film.FilmDto;
import com.cda.api.model.Film;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface IFileService {

    public String upload(MultipartFile file);

    String upload(MultipartFile file, String dir);

    public String uploadCloud(MultipartFile file);

    List<FilmDto> getImgUrl(List<FilmDto> allMovies);
}
