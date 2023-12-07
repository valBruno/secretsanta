package com.brunosousa.secretsanta.controller;

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

    @GetMapping("/")
    public ResponseEntity<String> draw() {

        String response = service.draw(Arrays.asList("Alice", "Bob", "Charlie", "David", "Eve", "Frank", "Grace", "Helen", "Igor", "Jack"));
        return ResponseEntity.ok(response);
    }

    @PostMapping("/draw")
    public ResponseEntity<String> drawNames(@RequestBody List<String> names) {
        String response = service.draw(names);
        return ResponseEntity.ok(response);
    }
}
