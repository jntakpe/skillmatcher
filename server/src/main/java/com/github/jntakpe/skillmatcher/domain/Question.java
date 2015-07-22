package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * @author jntakpe
 */
@Entity
public class Question extends GenericDomain {

    private String question;

    @Enumerated(EnumType.STRING)
    private Difficulte difficulte;

    @Enumerated(EnumType.STRING)
    private Resultat resultat;

    @ManyToOne
    private Competence competence;

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public Difficulte getDifficulte() {
        return difficulte;
    }

    public void setDifficulte(Difficulte difficulte) {
        this.difficulte = difficulte;
    }

    public Resultat getResultat() {
        return resultat;
    }

    public void setResultat(Resultat resultat) {
        this.resultat = resultat;
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
        return Objects.equals(question, question1.question) &&
                Objects.equals(competence, question1.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(question, competence);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("question", question)
                .append("competence", competence)
                .toString();
    }
}
