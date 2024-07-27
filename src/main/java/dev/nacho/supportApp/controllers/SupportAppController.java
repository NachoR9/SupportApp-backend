package dev.nacho.supportApp.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import dev.nacho.supportApp.models.Request;
import dev.nacho.supportApp.services.RequestService;

@RestController
public class SupportAppController {

    private RequestService services;

    public SupportAppController(RequestService services) {
        this.services = services;
    }

    @GetMapping(path = "/requests")
    public List<Request> getAll() {

        return services.getAll();

    }

    @PostMapping(path = "/requests")
    public Request createRequest(
            @RequestBody Request request) {

        return services.createRequest(request);
    }

    @GetMapping(path = "/requests/{id}")
    public Optional<Request>getRequest(@PathVariable Long id) {
            return services.getRequest(id);

    }


}