package com.cda.api.repository;

import com.cda.api.model.Utilisateur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Classe qui permet d'acceder aux données de l'entité Utilisateur
 */
public interface UtilisateurRepository extends CrudRepository<Utilisateur, Long> {

    @Query("select u from Utilisateur u where u.email=:pEmail and u.motDePasse =:pMotDePasse")
    Utilisateur login(@Param("pEmail") String email, @Param("pMotDePasse") String motDePasse);

    Utilisateur findUtilisateurById(Integer id);
}
