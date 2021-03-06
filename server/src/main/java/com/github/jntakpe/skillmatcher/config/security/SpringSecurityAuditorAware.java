package com.github.jntakpe.skillmatcher.config.security;

import com.github.jntakpe.skillmatcher.config.ConfigConstants;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Component;

/**
 * Implémentation de permettant de sauvegarder en DB les actions de l'utilisateur courant
 *
 * @author jntakpe
 */
@Component
public class SpringSecurityAuditorAware implements AuditorAware<String> {

  /**
   * Renvoi l'utilisateur courant
   *
   * @return l'utilisateur courant
   */
  @Override
  public String getCurrentAuditor() {
      return SecurityUtils.getCurrentUser().map(SpringSecurityUser::getUsername).orElse(ConfigConstants.SYSTEM_ACCOUNT);
  }
}
