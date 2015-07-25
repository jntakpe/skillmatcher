package com.github.jntakpe.skillmatcher.resource;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityExistsException;

/**
 * @author jntakpe
 */
@ControllerAdvice
public class ControllerAdvising {

    @ExceptionHandler(EntityExistsException.class)
    public ResponseEntity entityExist() {
        return new ResponseEntity(HttpStatus.CONFLICT);
    }
}
