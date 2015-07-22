package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jntakpe
 */
@Entity
public class Projet extends GenericDomain {

    private String nom;

    @OneToMany(mappedBy = "projet")
    private Set<Candidat> candidats = new HashSet<>();

    @ManyToMany
    @JoinTable(name = "projets_competences", joinColumns = {@JoinColumn(name = "projet_id", referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name = "competence_id", referencedColumnName = "id")})
    private Set<Competence> competences = new HashSet<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Candidat> getCandidats() {
        return candidats;
    }

    public void setCandidats(Set<Candidat> candidats) {
        this.candidats = candidats;
    }

    public Set<Competence> getCompetences() {
        return competences;
    }

    public void setCompetences(Set<Competence> competences) {
        this.competences = competences;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Projet projet = (Projet) o;
        return Objects.equals(nom, projet.nom);
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
