package com.brunosousa.secretsanta.controller;

import com.brunosousa.secretsanta.model.SecretSanta;
import com.brunosousa.secretsanta.service.SecretSantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(("/api/v1/secretsanta"))
public class SecretSantaController {

    @Autowired
    SecretSantaService service;

    @PostMapping("/")
    public ResponseEntity<SecretSanta> createSecretSanta(@RequestBody SecretSanta p) {
        SecretSanta save = service.createSecretSanta(p);
        return ResponseEntity.ok(save);
    }

    @PostMapping("/draw")
    public ResponseEntity<String> drawNames(@RequestBody List<String> names) {
        String response = service.draw(names);
        return ResponseEntity.ok(response);
    }
}
