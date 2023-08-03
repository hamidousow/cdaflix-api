package com.cda.api.service;

import com.cda.api.model.Utilisateur;

public interface IUtilisateurService {

    /**
     * @param email
     * @param motDePasse
     * @return
     */
    Utilisateur login(String email, String motDePasse);

    void save(Utilisateur utilisateur);

    Utilisateur findById(Integer id);


}
