CREATE TABLE secret_santa (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    description VARCHAR(255),
    location VARCHAR(255),
    organizer VARCHAR(255),
    status VARCHAR(255),
    giftExchangeDate TIMESTAMP
);

CREATE TABLE participant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    phone VARCHAR(255),
    CONSTRAINT UniqueUser UNIQUE (email, phone)
);

CREATE TABLE secret_santa_draw_participant (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    drawId BIGINT,
    participantId BIGINT,
    drawnParticipantId BIGINT,
    giftSuggestions VARCHAR(255),
    CONSTRAINT UniqueUserPerSecretSanta UNIQUE (drawId, participantId)
);