package com.brunosousa.secretsanta.repository;

import com.brunosousa.secretsanta.model.SecretSanta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SecretSantaRepository extends JpaRepository<SecretSanta, Long> {
}
