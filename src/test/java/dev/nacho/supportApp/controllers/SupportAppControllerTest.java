package dev.nacho.supportApp.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import dev.nacho.supportApp.exceptions.RequestNotFoundException;
import dev.nacho.supportApp.models.Request;
import dev.nacho.supportApp.services.RequestService;

public class SupportAppControllerTest {

    @Mock
    private RequestService services;
    private SupportAppController controller;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        controller = new SupportAppController(services);
    }

    @Test
    void testCreateRequest() {
        Request request = new Request(7L, "Java", LocalDateTime.now(), "Java failed", "I cannot open Java");
        when(services.createRequest(any())).thenReturn(request);
        Request result = controller.createRequest(request);
        assertEquals(request, result);

    }

    @Test
    void testGetAll() {
        List<Request> list = List.of(new Request(7L, "Java", LocalDateTime.now(), "Java failed", "I cannot open Java"));
        when(services.getAll()).thenReturn(list);
        List<Request> result = controller.getAll();
        assertEquals(list, result);
    }

    @Test
    void testGetRequest() {
        Long id = 7L;
        Optional<Request> request = Optional.of(new Request(7L, "Java", LocalDateTime.now(), "Java failed", "I cannot open Java"));
        when(services.getRequest(id)).thenReturn(request);
        Optional<Request> result = controller.getRequest(id);
        assertEquals(request, result);

    }

    @Test
    void testUpdateRequest() {
        Request update = new Request(7L, "Java", LocalDateTime.now(), "Java failed", "I cannot open Java");
        when(services.updateRequest(update)).thenReturn(update);
        ResponseEntity<Request> result = controller.updateRequest(update);
        assertEquals(200, result.getStatusCode().value());
        assertEquals(update, result.getBody());

    }

    @Test
    void testUpdateRequestError() {
        Request request = new Request(7L, "Java", LocalDateTime.now(), "Java failed", "I cannot open Java");
        RequestNotFoundException error = new RequestNotFoundException();
        when(services.updateRequest(request)).thenThrow(error);
        ResponseEntity<Request> result = controller.updateRequest(request);
        assertEquals(404, result.getStatusCode().value());

    }
}
