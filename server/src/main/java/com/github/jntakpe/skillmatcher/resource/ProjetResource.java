package com.github.jntakpe.skillmatcher.resource;

import com.github.jntakpe.skillmatcher.config.UrlConstants;
import com.github.jntakpe.skillmatcher.domain.Projet;
import com.github.jntakpe.skillmatcher.service.ProjetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author jntakpe
 */
@RestController
@RequestMapping(UrlConstants.PROJETS)
public class ProjetResource {

    private ProjetService projetService;

    @Autowired
    public ProjetResource(ProjetService projetService) {
        this.projetService = projetService;
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Projet> list() {
        return projetService.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable Long id) {
        projetService.delete(id);
    }
}
