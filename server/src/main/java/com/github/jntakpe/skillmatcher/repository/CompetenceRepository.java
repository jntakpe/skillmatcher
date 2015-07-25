package com.github.jntakpe.skillmatcher.repository;

import com.github.jntakpe.skillmatcher.domain.Competence;

import java.util.Optional;

/**
 * @author jntakpe
 */
public interface CompetenceRepository extends GenericRepository<Competence> {

    Optional<Competence> findByNomIgnoreCase(String nom);

}
