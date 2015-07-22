package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.util.Objects;

/**
 * @author jntakpe
 */
@Entity
public class Candidat extends GenericDomain {

    private String nom;

    private String prenom;

    private boolean interne;

    private Integer score;

    @Transient
    private Byte[] cv;

    @ManyToOne
    private Projet projet;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public boolean isInterne() {
        return interne;
    }

    public void setInterne(boolean interne) {
        this.interne = interne;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Byte[] getCv() {
        return cv;
    }

    public void setCv(Byte[] cv) {
        this.cv = cv;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Candidat candidat = (Candidat) o;
        return Objects.equals(nom, candidat.nom) &&
                Objects.equals(prenom, candidat.prenom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, prenom);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nom", nom)
                .append("prenom", prenom)
                .append("interne", interne)
                .append("score", score)
                .toString();
    }
}
