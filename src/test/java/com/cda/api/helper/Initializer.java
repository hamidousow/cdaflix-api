package com.cda.api.helper;

import com.cda.api.model.Utilisateur;

public class Initializer {

    public static Utilisateur initCreateUser() {
        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setEmail("test@test.com");
        utilisateur.setMotDePasse("test");
        return utilisateur;
    }

}
