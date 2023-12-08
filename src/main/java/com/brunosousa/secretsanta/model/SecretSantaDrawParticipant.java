package com.brunosousa.secretsanta.model;

import jakarta.persistence.*;

@Entity
@Table(uniqueConstraints = { @UniqueConstraint(name = "UniqueUserPerSecretSanta", columnNames = { "drawId", "participantId" }) })
public class SecretSantaDrawParticipant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long drawId;
    Long participantId;
    Long drawnParticipantId;
    String giftSuggestions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getDrawId() {
        return drawId;
    }

    public void setDrawId(Long drawId) {
        this.drawId = drawId;
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
