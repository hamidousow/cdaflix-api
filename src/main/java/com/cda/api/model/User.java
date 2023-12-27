package com.cda.api.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Table(name = "t_user_usr", schema = "cdaflix")
@Component
public class User {

    @Id
    @SequenceGenerator(name="usr_id_seq_gen", schema = "cdaflix")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usr_id_seq_gen")
    @Column(name = "usr_id")
    private Integer id;

    @Column(name = "usr_firstname")
    private String firstname;

    @Column(name = "usr_lastname")
    private String lastname;

    @Column(name = "usr_mail")
    private String mail;

    @Column(name = "usr_password")
    private String password;

    public Integer getId() {
        return id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
