package com.cda.api.controller;

import com.cda.api.mapper.FilmMapper;
import com.cda.api.service.IFilmService;
import com.cda.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    private IUserService utilisateurService;
    /**
     * injection d'UtilisateurMapper
     */

    @Autowired
    private IFilmService filmService;

    @Autowired
    private FilmMapper filmMapper;

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

    /*@RequestMapping(value = "/login", method = RequestMethod.POST)
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
    }*/


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

}
