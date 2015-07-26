package com.github.jntakpe.skillmatcher.resource;

import com.github.jntakpe.skillmatcher.config.UrlConstants;
import com.github.jntakpe.skillmatcher.domain.Competence;
import com.github.jntakpe.skillmatcher.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public List<Competence> create(@RequestBody @Valid Competence competence) throws InterruptedException {
        competenceService.save(competence);
        return competenceService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public List<Competence> remove(@PathVariable Long id) {
        competenceService.delete(id);
        return competenceService.findAll();
    }
}
