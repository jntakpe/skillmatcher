package com.github.jntakpe.skillmatcher.resource;

import com.github.jntakpe.skillmatcher.config.UrlConstants;
import com.github.jntakpe.skillmatcher.domain.Candidat;
import com.github.jntakpe.skillmatcher.service.CandidatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jntakpe
 */
@RestController
@RequestMapping(UrlConstants.CANDIDATS)
public class CandidatResource {

    private CandidatService candidatService;

    @Autowired
    public CandidatResource(CandidatService candidatService) {
        this.candidatService = candidatService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Candidat> list() {
        return candidatService.findAll();
    }
}
