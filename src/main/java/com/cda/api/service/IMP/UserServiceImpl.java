package com.cda.api.service.IMP;

import com.cda.api.model.User;
import com.cda.api.repository.UserRepository;
import com.cda.api.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation qui permet d'acceder aux services de l'entité Utilisateur
 */
@Service
public class UserServiceImpl implements IUserService {
    /**
     * Injection du DAO UtilisateurRepository
     */
    @Autowired
    private UserRepository userRepository;

    /**
     * Méthode qui permet de login un utilisateur à l'application cda-shop-admin
     *
     * @param email
     * @param motDePasse
     * @return Utilisateur (une seule instance)
     */

    public User login(String email, String motDePasse) {
        return userRepository.login(email, motDePasse);
    }

    @Override
    public void save(User utilisateur) {
        userRepository.save(utilisateur);
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findUserById(id);
    }
}
