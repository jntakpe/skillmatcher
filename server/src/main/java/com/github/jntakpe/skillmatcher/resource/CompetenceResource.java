package com.github.jntakpe.skillmatcher.resource;

import com.github.jntakpe.skillmatcher.config.UrlConstants;
import com.github.jntakpe.skillmatcher.domain.Competence;
import com.github.jntakpe.skillmatcher.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author jntakpe
 */
@RestController
@RequestMapping(UrlConstants.COMPETENCES)
public class CompetenceResource {

    private CompetenceService competenceService;

    @Autowired
    public CompetenceResource(CompetenceService competenceService) {
        this.competenceService = competenceService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Competence> list() {
        return competenceService.findAll();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Competence create(@RequestBody @Valid Competence competence) {
        return competenceService.save(competence);
    }
}
