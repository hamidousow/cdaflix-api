package com.cda.api.helper;

import com.cda.api.model.User;

public class Initializer {

    public static User initCreateUser() {
        User utilisateur = new User();
        utilisateur.setMail("test@test.com");
        utilisateur.setPassword("test");
        return utilisateur;
    }

}
