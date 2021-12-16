package com.example.controller;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.HttpStatus;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Post;
import io.micronaut.http.annotation.Status;
import io.micronaut.validation.Validated;

import javax.validation.Valid;

@Controller
@Validated
public class ExampleController {

    @Post(consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON)
    @Status(HttpStatus.NO_CONTENT)
    public HttpResponse<String> post(@Body @Valid ExampleDto body) {
        System.out.println("LLEGA");
        return HttpResponse.noContent();
    }
}
