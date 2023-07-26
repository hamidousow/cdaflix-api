package com.cda.api.service;

import com.cda.api.dto.UtilisateurDto;
import com.cda.api.repository.UtilisateurRepository;
import com.cda.api.model.Utilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementation qui permet d'acceder aux services de l'entité Utilisateur
 */
@Service
public class UtilisateurServiceImpl implements IUtilisateurService {
    /**
     * Injection du DAO UtilisateurRepository
     */
    @Autowired
    private UtilisateurRepository utilisateurRepository;

    /**
     * Méthode qui permet de login un utilisateur à l'application cda-shop-admin
     *
     * @param email
     * @param motDePasse
     * @return Utilisateur (une seule instance)
     */

    public Utilisateur login(String email, String motDePasse) {
        return utilisateurRepository.login(email, motDePasse);
    }

    @Override
    public void save(Utilisateur utilisateur) {
        utilisateurRepository.save(utilisateur);
    }

    @Override
    public Utilisateur findById(Integer id) {
        return utilisateurRepository.findUtilisateurById(id);
    }
}
