package com.brunosousa.secretsanta.service;

import com.brunosousa.secretsanta.model.AddParticipantRecord;
import com.brunosousa.secretsanta.model.SecretSanta;
import com.brunosousa.secretsanta.model.SecretSantaDrawParticipant;
import com.brunosousa.secretsanta.repository.SecretSantaDrawParticipantRepository;
import com.brunosousa.secretsanta.repository.SecretSantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class SecretSantaService {

    @Autowired
    SecretSantaRepository repository;

    @Autowired
    SecretSantaDrawParticipantRepository drawParticipantRepository;

    public String draw(List<String> names) {

        Collections.shuffle(names);

        List<String> result = new ArrayList<>();
        for (int i = 0; i < names.size(); i++) {
            String currentName = names.get(i);
            String nextName = names.get((i + 1) % names.size());
            result.add(currentName + " -> " + nextName);
        }

        System.out.println(result);

        String resultado = String.join("\n", result);

        return resultado;
    }

    public SecretSanta createSecretSanta(SecretSanta p) {
        return repository.save(p);
    }

    public SecretSanta getSecretSanta(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public SecretSantaDrawParticipant addParticipant(Long id, AddParticipantRecord r) {

        SecretSantaDrawParticipant add = new SecretSantaDrawParticipant();
        add.setDrawId(id);
        add.setParticipantId(r.participantId());
        add.setGiftSuggestions(r.giftSuggestions());

        return drawParticipantRepository.save(add);




    }
}
