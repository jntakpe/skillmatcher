package com.github.jntakpe.skillmatcher.service;

import com.github.jntakpe.skillmatcher.domain.Projet;
import com.github.jntakpe.skillmatcher.repository.ProjetRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author jntakpe
 */
@Service
public class ProjetService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProjetService.class);

    private ProjetRepository projetRepository;

    @Autowired
    public ProjetService(ProjetRepository projetRepository) {
        this.projetRepository = projetRepository;
    }

    @Transactional(readOnly = true)
    public List<Projet> findAll() {
        LOGGER.debug("Recherche des projets");
        return projetRepository.findAll();
    }

    @Transactional
    public void delete(Long id) {
        Projet projet = projetRepository.findOne(id);
        LOGGER.info("Suppression du projet {}", projet);
        projetRepository.delete(projet);
    }
}
