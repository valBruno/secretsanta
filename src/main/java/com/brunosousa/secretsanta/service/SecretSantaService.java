package com.brunosousa.secretsanta.service;

import com.brunosousa.secretsanta.model.AddParticipantRecord;
import com.brunosousa.secretsanta.model.SecretSanta;
import com.brunosousa.secretsanta.model.SecretSantaDrawParticipant;
import com.brunosousa.secretsanta.repository.SecretSantaDrawParticipantRepository;
import com.brunosousa.secretsanta.repository.SecretSantaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collections;
import java.util.List;

@Service
public class SecretSantaService {

    @Autowired
    SecretSantaRepository repository;

    @Autowired
    SecretSantaDrawParticipantRepository drawParticipantRepository;

    public List<SecretSantaDrawParticipant> draw(List<SecretSantaDrawParticipant> participants) {

        Collections.shuffle(participants);

        for (int i = 0; i < participants.size(); i++) {
            SecretSantaDrawParticipant current = participants.get(i);
            SecretSantaDrawParticipant next = participants.get((i + 1) % participants.size());
            current.setDrawnParticipantId(next.getParticipantId());
        }

        return participants;
    }

    public SecretSanta createSecretSanta(SecretSanta p) {
        return repository.save(p);
    }

    public SecretSanta getSecretSanta(Long id) {
        return repository.findById(id).orElseThrow();
    }

    public SecretSantaDrawParticipant addParticipant(Long id, AddParticipantRecord r) {

        SecretSantaDrawParticipant add = new SecretSantaDrawParticipant();
        add.setSecretSantaId(id);
        add.setParticipantId(r.participantId());
        add.setGiftSuggestions(r.giftSuggestions());

        return drawParticipantRepository.save(add);




    }

    @Transactional
    public SecretSanta drawSecretSanta(Long id) {

        SecretSanta secretSanta = repository.findById(id).orElseThrow();
//        TODO check if secret santa is open for drawing

        List<SecretSantaDrawParticipant> participants = drawParticipantRepository.findAllBySecretSantaId(id);

        List<SecretSantaDrawParticipant> drawnParticipants = draw(participants);

        secretSanta.setStatus("DRAWN");

        repository.save(secretSanta);

        drawParticipantRepository.saveAll(drawnParticipants);

        return secretSanta;


    }
}
