package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jntakpe
 */
@Entity
public class Competence extends GenericDomain {

    private String nom;

    @OneToMany(mappedBy = "competence")
    private Set<Question> questions = new HashSet<>();

    @ManyToMany(mappedBy = "competences")
    private Set<Projet> projets = new HashSet<>();

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Competence that = (Competence) o;
        return Objects.equals(nom, that.nom);
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
