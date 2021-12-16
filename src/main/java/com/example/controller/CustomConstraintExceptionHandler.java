package com.example.controller;

import io.micronaut.context.annotation.Replaces;
import io.micronaut.context.annotation.Requires;
import io.micronaut.http.HttpRequest;
import io.micronaut.http.HttpResponse;
import io.micronaut.http.annotation.Produces;
import io.micronaut.http.server.exceptions.ExceptionHandler;
import io.micronaut.validation.exceptions.ConstraintExceptionHandler;
import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.validation.ConstraintViolationException;

@Produces
@Singleton
@Requires(classes = {ConstraintViolationException.class, ExceptionHandler.class})
@Replaces(ConstraintExceptionHandler.class)
public class CustomConstraintExceptionHandler implements ExceptionHandler<ConstraintViolationException, HttpResponse> {

    private static final Logger logger
            = LoggerFactory.getLogger(CustomConstraintExceptionHandler.class);

    @Override
    public HttpResponse handle(HttpRequest request, ConstraintViolationException exception) {
        logger.info("ConstraintViolationException handled");
        return HttpResponse.badRequest();
    }
}
