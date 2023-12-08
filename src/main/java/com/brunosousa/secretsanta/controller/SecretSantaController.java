package com.brunosousa.secretsanta.controller;

import com.brunosousa.secretsanta.model.AddParticipantRecord;
import com.brunosousa.secretsanta.model.SecretSanta;
import com.brunosousa.secretsanta.model.SecretSantaDrawParticipant;
import com.brunosousa.secretsanta.service.SecretSantaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{id}")
    public ResponseEntity<SecretSanta> getSecretSanta(@PathVariable("id") Long id) {
        SecretSanta secretSanta = service.getSecretSanta(id);
        return ResponseEntity.ok(secretSanta);
    }

    @PostMapping("/{id}/participants")
    public ResponseEntity<SecretSantaDrawParticipant> addParticipant(@PathVariable("id") Long id, @RequestBody AddParticipantRecord r) {
        SecretSantaDrawParticipant secretSanta = service.addParticipant(id, r);
        return ResponseEntity.ok(secretSanta);
    }


    @PostMapping("/draw")
    public ResponseEntity<String> drawNames(@RequestBody List<String> names) {
        String response = service.draw(names);
        return ResponseEntity.ok(response);
    }
}
