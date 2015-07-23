package com.github.jntakpe.skillmatcher.service;

import com.github.jntakpe.skillmatcher.domain.Candidat;
import com.github.jntakpe.skillmatcher.repository.CandidatRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jntakpe
 */
@Service
public class CandidatService {

    private static final Logger LOGGER = LoggerFactory.getLogger(CandidatService.class);

    private CandidatRepository candidatRepository;

    @Autowired
    public CandidatService(CandidatRepository candidatRepository) {
        this.candidatRepository = candidatRepository;
    }

    public List<Candidat> findAll() {
        LOGGER.debug("Récupération de tous les candidats");
        return candidatRepository.findAll();
    }
}
