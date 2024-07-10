package dev.nacho.supportApp.controllers;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.nacho.supportApp.models.SupportApp;
import dev.nacho.supportApp.services.SupportAppService;


@RestController
public class SupportAppController {

    private SupportAppService services;

    public SupportAppController(SupportAppService services) {
        this.services = services;
    }

    @GetMapping(path = "/supportapps")
    public List<SupportApp> index() {

        return services.getAll();

    }

}