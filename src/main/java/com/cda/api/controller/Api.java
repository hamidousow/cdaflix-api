package com.cda.api.controller;

import com.cda.api.dto.*;
import com.cda.api.mapper.FilmMapper;
import com.cda.api.mapper.UtilisateurMapper;
import com.cda.api.model.Film;
import com.cda.api.model.Utilisateur;
import com.cda.api.service.IFilmService;
import com.cda.api.service.IUtilisateurService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import javax.validation.constraints.NotNull;
import java.awt.image.BufferedImage;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * WebService REST pour les opérations de l'application Admin
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/app")
public class Api {

    /**
     * injection d'UtilisateurService
     */
    @Autowired
    private IUtilisateurService utilisateurService;
    /**
     * injection d'UtilisateurMapper
     */
    @Autowired
    private UtilisateurMapper utilisateurMapper;

    @Autowired
    private IFilmService filmService;

    @Autowired
    private FilmMapper filmMapper;

    @Value("${images.path}")
    private String imagesDir;

    @GetMapping("/home")
    public ResponseEntity<String> home() {
        return ResponseEntity.ok("Bienvenue dans l'api cda");
    }

    /*@RequestMapping(value = "/suscribe", method = RequestMethod.POST)
    public ResponseEntity<UtilisateurDto> suscribe(@RequestBody @NonNull UtilisateurDto pUtilisateurDto) {

        Utilisateur utilisateur = utilisateurMapper.utilisateurDtoToUtilisateur(pUtilisateurDto);
        utilisateurService.save(utilisateur);
        pUtilisateurDto = utilisateurService.findById(utilisateur.getId());
        if(pUtilisateurDto == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(pUtilisateurDto);

    }*/

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<UtilisateurCoDto> login(@RequestBody @NonNull final UtilisateurDto pUtilisateurDto) {
        Boolean isLoginOk = false;
        Utilisateur utilisateurResult = utilisateurService.login(pUtilisateurDto.getEmail(), pUtilisateurDto.getMotDePasse());
        //
        System.out.println(utilisateurResult.toString());
        //
        UtilisateurCoDto utilisateurDto = utilisateurMapper.utilisateurToUtilisateurCoDto(utilisateurResult);
        System.out.println(utilisateurDto.getFilmsFavoris().toString());
        //return new ResponseEntity(isLoginOk, HttpStatus.OK);
        return ResponseEntity.ok(utilisateurDto);
    }

    @GetMapping("/allMovies")
    public ResponseEntity<List<FilmDto>> allMovies() {
        List<Film> allMovies = filmService.getAll();
        List<FilmDto> allMoviesDto = new ArrayList<>();
        if(allMovies != null) {
            for(Film film: allMovies) {
                film.setImgBytes(
                    imageToByte(imagesDir + film.getImg())
                );
            }

            allMoviesDto = allMovies.stream().map(film -> filmMapper.filmToFilmDto(film)).collect(Collectors.toList());
        }
        return ResponseEntity.ok(allMoviesDto);
    }

    private byte[] imageToByte(String imgPath) {
        System.out.println(imgPath);
        Path currentDir = Paths.get(".");
        Path fullPath = currentDir.toAbsolutePath();
        System.out.println(fullPath);
        try {
            byte [] imgBytes = Files.readAllBytes(Paths.get(imgPath));
            return imgBytes;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    @PostMapping("/getAllMovies")
    public ResponseEntity<List<FilmDto>> getAllMovies(@RequestBody @NotNull UtilisateurDto pUtilisateurDto) {
        Utilisateur utilisateur = utilisateurService.login(pUtilisateurDto.getEmail(), pUtilisateurDto.getMotDePasse());
        if(utilisateur==null) {
           return ResponseEntity.notFound().build();
        }
        List<Film> films = utilisateur.getFilmsFavoris();
        List<FilmDto> listFilmsDto = films.stream().map(film -> filmMapper.filmToFilmDto(film)).collect(Collectors.toList());
        return ResponseEntity.ok(listFilmsDto);
    }*/

    /*@GetMapping("/getMoviesByUser")
    public ResponseEntity<List<FilmDto>> getMoviesByUser(@RequestParam(name = "idUser") Integer idUser) {
        System.out.println(idUser);
        Utilisateur utilisateur = utilisateurService.findById(idUser);
        List<FilmDto>listFilmsDto = new ArrayList<>();

        if(utilisateur==null) {
            return ResponseEntity.notFound().build();
        }

        List<Film> films = utilisateur.getFilmsFavoris();
        if(films != null) {
            for(Film film: films) {
                film.setImgBytes(
                        imageToByte(imagesDir + film.getImg())
                );
            }
            listFilmsDto = films.stream().map(film -> filmMapper.filmToFilmDto(film)).collect(Collectors.toList());
        }

        return ResponseEntity.ok(listFilmsDto);
    }*/

    //TODO : corriger le delete pour un user
    @PostMapping("/deleteOneMovie")
    public ResponseEntity<UtilisateurCoDto> deleteOne(@RequestBody FilmDeleteDto filmDeleteDto, MultipartFile file) {
        System.out.println(filmDeleteDto.toString());
        /*Integer idUser = filmDeleteDto.getUtilisateurCoDto().getId();
        Utilisateur user = utilisateurService.findById(idUser);*/
        /*Film filmFind = filmService.findById(filmDeleteDto.getIdFilm());
        List<Film> filmsDto = utilisateurService.findById(idUser).getFilmsFavoris();
        filmsDto.remove(filmFind);*/
        /*filmService.delete(filmService.findById(filmDeleteDto.getIdFilm()));
        utilisateurService.save(user);*/
        return ResponseEntity.ok().build();
    }

    @PostMapping(value = "/uploadFilm", consumes = { MediaType.APPLICATION_JSON_VALUE, MediaType.MULTIPART_FORM_DATA_VALUE })
    public ResponseEntity<Film> postFilm(@RequestBody FilmUploadDto filmDto) {
        MultipartFile file = filmDto.getFile();
        //Film film = filmMapper.filmDtoToFilm(filmDto);
        //System.out.println(film.toString());
        //filmService.save(film);
        return null;
    }
}
