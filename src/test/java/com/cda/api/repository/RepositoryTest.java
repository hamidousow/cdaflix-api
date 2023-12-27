package com.cda.api.repository;

import com.cda.api.helper.Initializer;
import com.cda.api.model.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("test")
public class RepositoryTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("Create User Test ")
    public void insertUserShouldReturnUser() {
        final User utilisateur = Initializer.initCreateUser();
        userRepository.save(utilisateur);
        Assertions.assertNotNull(utilisateur.getId());
        //Assertions.assertNotNull(utilisateur.getCreatedAt());
    }

}
