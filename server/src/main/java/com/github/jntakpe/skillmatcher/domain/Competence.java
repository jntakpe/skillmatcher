package com.github.jntakpe.skillmatcher.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/**
 * @author jntakpe
 */
@Entity
public class Competence extends GenericDomain {

    @NotNull
    @Column(unique = true)
    private String nom;

    @JsonIgnoreProperties("competence")
    @OneToMany(mappedBy = "competence")
    private Set<Question> questions = new HashSet<>();

    @JsonIgnoreProperties("competence")
    @OneToMany(mappedBy = "competence")
    private Set<ProjetCompetence> projetsCompetences = new HashSet<>();

    @Transient
    private Integer scoreQuestions;

    @Transient
    private Integer nbProjetsDemandeurs;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Set<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(Set<Question> questions) {
        this.questions = questions;
    }

    public Set<ProjetCompetence> getProjetsCompetences() {
        return projetsCompetences;
    }

    public void setProjetsCompetences(Set<ProjetCompetence> projetsCompetences) {
        this.projetsCompetences = projetsCompetences;
    }

    public Integer getScoreQuestions() {
        return scoreQuestions;
    }

    public void setScoreQuestions(Integer scoreQuestions) {
        this.scoreQuestions = scoreQuestions;
    }

    public Integer getNbProjetsDemandeurs() {
        return nbProjetsDemandeurs;
    }

    public void setNbProjetsDemandeurs(Integer nbProjetsDemandeurs) {
        this.nbProjetsDemandeurs = nbProjetsDemandeurs;
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
