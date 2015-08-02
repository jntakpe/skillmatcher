package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;
import java.time.LocalDate;
import java.util.Objects;

/**
 * @author jntakpe
 */
@Entity
public class Candidat extends GenericDomain {

    private String nom;

    private boolean interne;

    private Integer tarif;

    private LocalDate dateDispo;

    private Integer anneesXp;

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

    public boolean isInterne() {
        return interne;
    }

    public void setInterne(boolean interne) {
        this.interne = interne;
    }

    public Integer getAnneesXp() {
        return anneesXp;
    }

    public void setAnneesXp(Integer anneesXp) {
        this.anneesXp = anneesXp;
    }

    public LocalDate getDateDispo() {
        return dateDispo;
    }

    public void setDateDispo(LocalDate dateDispo) {
        this.dateDispo = dateDispo;
    }

    public Integer getTarif() {
        return tarif;
    }

    public void setTarif(Integer tarif) {
        this.tarif = tarif;
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

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Candidat)) return false;
        Candidat candidat = (Candidat) o;
        return Objects.equals(nom, candidat.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("nom", nom)
                .toString();
    }
}
