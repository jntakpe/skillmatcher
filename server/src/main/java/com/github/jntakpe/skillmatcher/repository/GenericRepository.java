package com.github.jntakpe.skillmatcher.repository;

import com.github.jntakpe.skillmatcher.domain.GenericDomain;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author jntakpe
 */
public interface GenericRepository<T extends GenericDomain> extends JpaRepository<T, Long> {

}
