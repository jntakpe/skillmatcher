package com.github.jntakpe.skillmatcher.config.security;

import com.github.jntakpe.skillmatcher.domain.Utilisateur;
import com.github.jntakpe.skillmatcher.service.UtilisateurService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Récupération de l'utilisateur tentant de s'authentifier
 *
 * @author jntakpe
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserDetailsServiceImpl.class);

    private UtilisateurService utilisateurService;

    @Autowired
    public UserDetailsServiceImpl(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    private static SpringSecurityUser mapUserDetails(Utilisateur utilisateur) {
        List<GrantedAuthority> auths = mapAuthorities(utilisateur);
        //FIXME change pass
        return new SpringSecurityUser(utilisateur.getId(), utilisateur.getEmail(), "test", auths);
    }

    private static List<GrantedAuthority> mapAuthorities(Utilisateur utilisateur) {
        return utilisateur.getRoles().stream()
                .map(role -> new SimpleGrantedAuthority(role.getNom()))
                .collect(Collectors.toList());
    }

    @Override
    public SpringSecurityUser loadUserByUsername(String email) {
        LOGGER.debug("Authentification de l'utilisateur avec l'addresse mail {}", email);
        Utilisateur user = utilisateurService.findByEmailWithAuthorities(email);
        return mapUserDetails(user);
    }
}
