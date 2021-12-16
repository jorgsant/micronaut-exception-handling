package com.example.controller;

import io.micronaut.http.HttpRequest;
import io.micronaut.http.client.HttpClient;
import io.micronaut.http.client.annotation.Client;
import io.micronaut.http.client.exceptions.HttpClientResponseException;
import io.micronaut.runtime.EmbeddedApplication;
import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import jakarta.inject.Inject;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

@MicronautTest
class ExampleControllerTest {

    @Inject
    private EmbeddedApplication<?> application;

    @Inject
    @Client("/")
    private HttpClient client;

    @Test
    void testItWorks() {
        Assertions.assertTrue(application.isRunning());
    }

    @Test
    void testConstraintExceptionHandled() {
        var request = HttpRequest.POST("/", "{}").header("Content-type", "application/json");
        var e =
                Assertions.assertThrows(
                        HttpClientResponseException.class, () -> client.toBlocking().exchange(request));
    }

}
