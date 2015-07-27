package com.github.jntakpe.skillmatcher.resource;

import com.github.jntakpe.skillmatcher.config.UrlConstants;
import com.github.jntakpe.skillmatcher.domain.Competence;
import com.github.jntakpe.skillmatcher.service.CompetenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Competence> create(@RequestBody @Valid Competence competence) {
        return new ResponseEntity<>(competenceService.save(competence), HttpStatus.CREATED);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Competence update(@PathVariable Long id, @RequestBody @Valid Competence competence) {
        return competenceService.save(competence);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void remove(@PathVariable Long id) {
        competenceService.delete(id);
    }

}
