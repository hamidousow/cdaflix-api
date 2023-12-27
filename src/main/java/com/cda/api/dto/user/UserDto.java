package com.cda.api.dto.user;

import com.cda.api.dto.film.FilmDto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Getter
public class UserDto {

    @JsonProperty("mail")
    private String mail;
    @JsonProperty("firstname")
    private String firstname;

    @JsonProperty("lastname")
    private String lastname;

    @JsonProperty("password")
    private String password;


    public void setMail(String mail) {
        this.mail = mail;
    }


    public void setPassword(String password) {
        this.password = password;
    }

}
