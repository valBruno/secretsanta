package com.brunosousa.secretsanta.controller;

import com.brunosousa.secretsanta.model.Participant;
import com.brunosousa.secretsanta.repository.ParticipantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(("/api/v1/secretsanta/participants"))
public class ParticipantController {

    @Autowired
    ParticipantRepository repository;

    @PostMapping("/")
    public ResponseEntity<Participant> createParticipant(@RequestBody Participant p) {
        Participant save = repository.save(p);
        return ResponseEntity.ok(save);
    }
}
