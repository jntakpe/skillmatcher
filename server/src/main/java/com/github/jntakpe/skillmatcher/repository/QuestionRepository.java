package com.github.jntakpe.skillmatcher.repository;

import com.github.jntakpe.skillmatcher.domain.Question;

import java.util.Optional;

/**
 * @author jntakpe
 */
public interface QuestionRepository extends GenericRepository<Question> {

    Optional<Question> findByEnonceIgnoreCase(String enonce);
}
