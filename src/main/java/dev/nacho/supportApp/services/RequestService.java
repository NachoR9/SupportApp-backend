package dev.nacho.supportApp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import dev.nacho.supportApp.models.Request;
import dev.nacho.supportApp.repositories.RequestRepository;

@Service
public class RequestService {
    RequestRepository repository;

    public RequestService(RequestRepository repository){
        this.repository = repository;
    }

    public List<Request> getAll() {
        List<Request> requests = repository.findAll();
        return requests;
    }
}