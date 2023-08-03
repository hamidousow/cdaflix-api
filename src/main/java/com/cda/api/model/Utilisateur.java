package com.cda.api.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "T_UTILISATEUR_UTL", schema = "cdaflix")
@Component
public class Utilisateur implements Serializable {
    @Id
    @SequenceGenerator(name = "utl_id_seq_gen", sequenceName = "cdaflix.t_utilisateur_utl_utl_id_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "utl_id_seq_gen")
    @Column(name = "UTL_ID")
    private Integer id;
    @Column(name = "UTL_MOT_DE_PASSE", nullable = false, length = 50)
    private String motDePasse;
    @Column(name = "UTL_ADRESSE_EMAIL", nullable = false, length = 50)
    private String email;
    @Column(name = "UTL_CREATED_AT", nullable = false, updatable = false)
    private Date createdAt;
    @Column(name = "UTL_UPDATED_AT", nullable = false)
    private Date updatedAt;


    /**
     * Setter une date création et une date de mise à jour avant de persister
     */
    @PrePersist
    void setDateCreation() {
        Date date = new Date();
        this.setCreatedAt(date);
        this.setUpdatedAt(date);
    }

    /**
     * Mettre à jour la date de mise à jour à chaque fois qu'on fait un update
     */
    @PreUpdate
    void setDateModification() {
        this.setUpdatedAt(new Date());
    }

    /**
     * Gets id.
     *
     * @return value of id
     */
    public Integer getId() {
        return id;
    }

    /**
     * Sets id.
     *
     * @param id value of id
     */
    public void setId(final Integer id) {
        this.id = id;
    }

    /**
     * Gets motDePasse.
     *
     * @return value of motDePasse
     */
    public String getMotDePasse() {
        return motDePasse;
    }

    /**
     * Sets motDePasse.
     *
     * @param motDePasse value of motDePasse
     */
    public void setMotDePasse(final String motDePasse) {
        this.motDePasse = motDePasse;
    }

    /**
     * Gets email.
     *
     * @return value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets email.
     *
     * @param email value of email
     */
    public void setEmail(final String email) {
        this.email = email;
    }

    /**
     * Gets createdAt.
     *
     * @return value of createdAt
     */
    public Date getCreatedAt() {
        return createdAt;
    }

    /**
     * Sets createdAt.
     *
     * @param createdAt value of createdAt
     */
    public void setCreatedAt(final Date createdAt) {
        this.createdAt = createdAt;
    }

    /**
     * Gets updatedAt.
     *
     * @return value of updatedAt
     */
    public Date getUpdatedAt() {
        return updatedAt;
    }

    /**
     * Sets updatedAt.
     *
     * @param updatedAt value of updatedAt
     */
    public void setUpdatedAt(final Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) return true;
        if (!(o instanceof Utilisateur)) return false;
        Utilisateur that = (Utilisateur) o;
        return Objects.equals(getId(), that.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        return "Utilisateur{" +
                "id=" + id +
                ", motDePasse='" + motDePasse + '\'' +
                ", email='" + email + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}
