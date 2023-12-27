package com.cda.api.repository;

import com.cda.api.model.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

/**
 * Classe qui permet d'acceder aux données de l'entité Utilisateur
 */
public interface UserRepository extends CrudRepository<User, Long> {

    @Query("select u from User u where u.mail=:mail and u.password =:password")
    User login(@Param("mail") String mail, @Param("password") String password);

    User findUserById(Integer id);
}
