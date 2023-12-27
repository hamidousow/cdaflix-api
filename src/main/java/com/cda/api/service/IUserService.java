package com.cda.api.service;

import com.cda.api.model.User;

public interface IUserService {

    /**
     * @param email
     * @param motDePasse
     * @return
     */
    User login(String email, String motDePasse);

    void save(User utilisateur);

    User findById(Integer id);


}
