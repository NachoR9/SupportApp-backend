package dev.nacho.supportApp.services;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import dev.nacho.supportApp.exceptions.RequestNotFoundException;
import dev.nacho.supportApp.models.Request;
import dev.nacho.supportApp.repositories.RequestRepository;

@Service
public class RequestService {
    RequestRepository repository;

    public RequestService(RequestRepository repository) {
        this.repository = repository;
    }

    public List<Request> getAll() {
        List<Request> requests = repository.findAll(Sort.by("date"));
        return requests;
    }

    public Request createRequest(Request request) {
        return repository.save(request);

    }

    public Optional<Request> getRequest(Long id) {
        return repository.findById(id);
    }

    public Request updateRequest(Request request) {
        if (!repository.existsById(request.getId())) {
            throw new RequestNotFoundException();

        }
        return repository.save(request);
    }
}
