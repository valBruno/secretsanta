package com.brunosousa.secretsanta.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueUserPerSecretSanta", columnNames = { "secretSantaId", "participantId" }) })
public class SecretSantaDrawParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long secretSantaId;
    Long participantId;
    Long drawnParticipantId;
    String giftSuggestions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSecretSantaId() {
        return secretSantaId;
    }

    public void setSecretSantaId(Long secretSantaId) {
        this.secretSantaId = secretSantaId;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getDrawnParticipantId() {
        return drawnParticipantId;
    }

    public void setDrawnParticipantId(Long drawnParticipantId) {
        this.drawnParticipantId = drawnParticipantId;
    }

    public String getGiftSuggestions() {
        return giftSuggestions;
    }

    public void setGiftSuggestions(String giftSuggestions) {
        this.giftSuggestions = giftSuggestions;
    }
}
