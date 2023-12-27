package com.cda.api.model;

import lombok.*;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Component
@Table(name="T_FAVORIS_FAV", schema = "cdaflix")
public class Favoris {

    @Id
    @SequenceGenerator(name = "fav_id_seq_gen", sequenceName = "cdaflix.t_favoris_fav_fav_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "fav_id_seq_gen")
    @Column(name = "FAV_ID")
    private Integer id;

    @Column(name ="FAV_ICONE")
    private String icone;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "utl_id")
    private User user;

    public Favoris() {
    }

    public Favoris(Integer id, String icone, User user) {
        this.id = id;
        this.icone = icone;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public String getIcone() {
        return icone;
    }

    public User getUser() {
        return user;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setIcone(String icone) {
        this.icone = icone;
    }

    public void setUser(User user) {
        this.user = user;
    }


}
