package dev.nacho.supportApp.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nacho.supportApp.models.Request;
import dev.nacho.supportApp.services.RequestService;


@RestController
public class SupportAppController {

    private RequestService services;

    public SupportAppController(RequestService services) {
        this.services = services;
    }

    @GetMapping(path = "/supportapps")
    public List<Request> index() {

        return services.getAll();

    }

    // @PostMapping ...crear


    // @PutMapping actualizar
}