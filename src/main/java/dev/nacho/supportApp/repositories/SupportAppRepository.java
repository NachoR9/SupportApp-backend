package dev.nacho.supportApp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.nacho.supportApp.models.SupportApp;


public interface SupportAppRepository extends JpaRepository<SupportApp, Long> {
    
}