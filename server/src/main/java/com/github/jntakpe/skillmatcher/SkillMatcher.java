package com.github.jntakpe.skillmatcher;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Classe mère de l'application
 *
 * @author jntakpe
 */
@SpringBootApplication
public class SkillMatcher {

    /**
     * Méthode appellée pour le démarrage de l'application
     *
     * @param args paramètres de l'application
     */
    public static void main(String[] args) {
        SpringApplication.run(SkillMatcher.class, args);
    }
}
