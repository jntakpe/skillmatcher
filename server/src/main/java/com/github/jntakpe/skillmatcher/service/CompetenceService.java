package com.github.jntakpe.skillmatcher.service;

import com.github.jntakpe.skillmatcher.domain.Competence;
import com.github.jntakpe.skillmatcher.repository.CompetenceRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;
import java.util.List;
import java.util.Optional;

/**
 * @author jntakpe
 */
@Service
public class CompetenceService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CompetenceService.class);

    private CompetenceRepository competenceRepository;

    @Autowired
    public CompetenceService(CompetenceRepository competenceRepository) {
        this.competenceRepository = competenceRepository;
    }

    @Transactional(readOnly = true)
    public List<Competence> findAll() {
        LOGGER.debug("Recherche des compétences");
        return competenceRepository.findAll();
    }

    @Transactional
    public Competence save(Competence competence) {
        LOGGER.info("Enregistrement de la competence {}", competence);
        if (isViolatingConstraint(competence)) {
            throw new EntityExistsException();
        }
        return competenceRepository.save(competence);
    }

    @Transactional
    public void delete(Long id) {
        Competence competence = competenceRepository.findOne(id);
        LOGGER.info("Suppression de la compétence {}", competence);
        competenceRepository.delete(competence);
    }

    @Transactional(readOnly = true)
    public boolean isViolatingConstraint(Competence competence) {
        return findByNomIgnoreCase(competence.getNom())
                .map(c -> !c.getId().equals(competence.getId()))
                .orElse(false);
    }

    @Transactional(readOnly = true)
    private Optional<Competence> findByNomIgnoreCase(String nom) {
        LOGGER.debug("Recherche d'une competence avec le nom {}", nom);
        return competenceRepository.findByNomIgnoreCase(nom);
    }

}
