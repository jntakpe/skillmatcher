package com.github.jntakpe.skillmatcher.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import java.util.Objects;

/**
 * @author jntakpe
 */
@Entity
public class ProjetCompetence extends GenericDomain {

    @NotNull
    private Integer coefficient;

    @ManyToOne(optional = false)
    private Projet projet;

    @ManyToOne(optional = false)
    private Competence competence;

    public Integer getCoefficient() {
        return coefficient;
    }

    public void setCoefficient(Integer coefficient) {
        this.coefficient = coefficient;
    }

    public Projet getProjet() {
        return projet;
    }

    public void setProjet(Projet projet) {
        this.projet = projet;
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
        if (!(o instanceof ProjetCompetence)) return false;
        ProjetCompetence that = (ProjetCompetence) o;
        return Objects.equals(projet, that.projet) &&
                Objects.equals(competence, that.competence);
    }

    @Override
    public int hashCode() {
        return Objects.hash(projet, competence);
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("projet", projet)
                .append("competence", competence)
                .toString();
    }
}
