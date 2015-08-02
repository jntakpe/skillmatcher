package com.github.jntakpe.skillmatcher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jntakpe
 */
@Entity
public class Projet extends GenericDomain {

    @NotNull
    @Column(unique = true, nullable = false)
    private String nom;

    @JsonIgnoreProperties("projet")
    @OneToMany(mappedBy = "projet", fetch = FetchType.EAGER)
    private Set<Candidat> candidats = new HashSet<>();

    @JsonIgnoreProperties("projet")
    @OneToMany(mappedBy = "projet", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<ProjetCompetence> projetsCompetences = new HashSet<>();

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

    public Set<ProjetCompetence> getProjetsCompetences() {
        return projetsCompetences;
    }

    public void setProjetsCompetences(Set<ProjetCompetence> projetsCompetences) {
        this.projetsCompetences = projetsCompetences;
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
