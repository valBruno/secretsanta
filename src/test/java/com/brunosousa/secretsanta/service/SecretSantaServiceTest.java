package com.brunosousa.secretsanta.service;

import com.brunosousa.secretsanta.model.AddParticipantRecord;
import com.brunosousa.secretsanta.model.SecretSanta;
import com.brunosousa.secretsanta.model.SecretSantaDrawParticipant;
import com.brunosousa.secretsanta.repository.SecretSantaDrawParticipantRepository;
import com.brunosousa.secretsanta.repository.SecretSantaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class SecretSantaServiceTest {

    @InjectMocks
    SecretSantaService secretSantaService;

    @Mock
    SecretSantaRepository secretSantaRepository;

    @Mock
    SecretSantaDrawParticipantRepository drawParticipantRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    @DisplayName("Should create a Secret Santa")
    void shouldCreateSecretSanta() {
        SecretSanta secretSanta = new SecretSanta();
        when(secretSantaRepository.save(any(SecretSanta.class))).thenReturn(secretSanta);

        SecretSanta result = secretSantaService.createSecretSanta(secretSanta);

        assertEquals(secretSanta, result);
    }

    @Test
    @DisplayName("Should get a Secret Santa by id")
    void shouldGetSecretSantaById() {
        SecretSanta secretSanta = new SecretSanta();
        when(secretSantaRepository.findById(any(Long.class))).thenReturn(Optional.of(secretSanta));

        SecretSanta result = secretSantaService.getSecretSanta(1L);

        assertEquals(secretSanta, result);
    }

    @Test
    @DisplayName("Should add a participant to a Secret Santa")
    void shouldAddParticipantToSecretSanta() {
        AddParticipantRecord record = new AddParticipantRecord(1L, "Books, Chocolates");
        SecretSantaDrawParticipant participant = new SecretSantaDrawParticipant();
        when(drawParticipantRepository.save(any(SecretSantaDrawParticipant.class))).thenReturn(participant);

        SecretSantaDrawParticipant result = secretSantaService.addParticipant(1L, record);

        assertEquals(participant, result);
    }

    @Test
    @DisplayName("Should draw a Secret Santa")
    void shouldDrawSecretSanta() {
        SecretSanta secretSanta = new SecretSanta();
        when(secretSantaRepository.findById(any(Long.class))).thenReturn(Optional.of(secretSanta));
        when(drawParticipantRepository.findAllBySecretSantaId(any(Long.class))).thenReturn(Arrays.asList(new SecretSantaDrawParticipant(), new SecretSantaDrawParticipant()));
        when(secretSantaRepository.save(any(SecretSanta.class))).thenReturn(secretSanta);
        when(drawParticipantRepository.saveAll(any(List.class))).thenReturn(Arrays.asList(new SecretSantaDrawParticipant(), new SecretSantaDrawParticipant()));

        SecretSanta result = secretSantaService.drawSecretSanta(1L);

        assertEquals(secretSanta, result);
        verify(secretSantaRepository, times(1)).save(secretSanta);
        verify(drawParticipantRepository, times(1)).saveAll(any(List.class));
    }
}