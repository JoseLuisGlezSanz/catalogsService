package com.example.catalogservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.catalogservice.dto.GymResponse;

@FeignClient(name = "user-microservice", url = "/api/v1/gyms")
public interface GymClient {
    
    @GetMapping("/{id}")
    GymResponse findById(@PathVariable Long id);
    
    @GetMapping("/exists/{id}")
    Boolean existsById(@PathVariable Long id);
}