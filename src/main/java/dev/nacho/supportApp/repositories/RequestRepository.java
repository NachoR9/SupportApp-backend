package dev.nacho.supportApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nacho.supportApp.models.Request;


public interface RequestRepository extends JpaRepository<Request, Long> {
    
}