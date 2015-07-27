package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author jntakpe
 */
@Entity
public class Question extends GenericDomain {

    @NotNull
    @Column(unique = true, nullable = false)
    private String enonce;

    @NotNull
    @Enumerated(EnumType.STRING)
    private Difficulte difficulte;

    @ManyToOne
    private Competence competence;

    public String getEnonce() {
        return enonce;
    }

    public void setEnonce(String enonce) {
        this.enonce = enonce;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public Competence getCompetence() {
        return competence;
    }

    public void setCompetence(Competence competence) {
        this.competence = competence;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Question question1 = (Question) o;
        return Objects.equals(enonce, question1.enonce) &&
                Objects.equals(competence, question1.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(enonce, competence);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("enonce", enonce)
                .append("competence", competence)
                .toString();
    }
}
