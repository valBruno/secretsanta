package com.brunosousa.secretsanta.controller;

import com.brunosousa.secretsanta.service.SecretSantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/secretsanta"))
public class SecretSantaController {

    @Autowired
    SecretSantaService service;

    @GetMapping("/")
    public ResponseEntity<String> draw() {
        return ResponseEntity.ok("Hello, world!");
    }
}
