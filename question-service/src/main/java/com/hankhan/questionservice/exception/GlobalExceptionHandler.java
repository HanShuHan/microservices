/*
 * Project name: Microservices
 * Date: September 15, 2024
 */

package com.hankhan.questionservice.exception;


import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.server.ResponseStatusException;

/**
 * Todo: What does this class do...
 *
 * @author Shu-Han Han
 * @version 1.0
 * @since 20.0.1
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ResponseStatusException.class)
    public ResponseEntity<?> handleResponseStatusException (ResponseStatusException ex) {
        return new ResponseEntity<>(ex.getReason(), HttpStatusCode.valueOf(ex.getBody().getStatus()));
    }
}