package com.example.catalogservice.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.catalogservice.dto.UserResponse;

@FeignClient(name = "user-microservice", path = "/api/v1/users")
public interface UserClient {
    @GetMapping("/{id}")
    UserResponse findById(@PathVariable Long id);
    
    @GetMapping("/username/{userName}")
    UserResponse findByUsername(@PathVariable String userName);
}