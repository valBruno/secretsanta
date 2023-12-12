package com.brunosousa.secretsanta.repository;

import com.brunosousa.secretsanta.model.SecretSantaDrawParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SecretSantaDrawParticipantRepository extends JpaRepository<SecretSantaDrawParticipant, Long> {
    List<SecretSantaDrawParticipant> findAllBySecretSantaId(Long id);
}
