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
        return ResponseEntity.ok("Bienvenue sur Cdaflix");
    }  

}
