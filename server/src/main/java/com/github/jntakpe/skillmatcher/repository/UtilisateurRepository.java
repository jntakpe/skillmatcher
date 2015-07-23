package com.github.jntakpe.skillmatcher.repository;

import com.github.jntakpe.skillmatcher.domain.Utilisateur;

import java.util.Optional;

/**
 * @author jntakpe
 */
public interface UtilisateurRepository extends GenericRepository<Utilisateur> {

    Optional<Utilisateur> findByEmailIgnoreCase(String email);
}
