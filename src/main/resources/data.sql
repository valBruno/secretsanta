

INSERT INTO participant(id, name, email)
VALUES
(1,'Alice', 'alice@example.com')
,(2,'Bob', 'bob@example.com')
,(3,'Charlie', 'charlie@example.com')
,(4,'David', 'david@example.com')
,(5,'Eve', 'eve@example.com')
,(6,'Frank', 'frank@example.com')
,(7,'Grace', 'grace@example.com')
,(8,'Helen', 'helen@example.com')
,(9,'Igor', 'igor@example.com')
,(10,'Jack', 'jack@example.com')
;

INSERT INTO secret_santa(id, name, description, location, organizer, status, gift_exchange_date, created_at)
VALUES (1, 'Secret Santa Event', 'Office Secret Santa', 'Office', 'Alice', 'Active', '2023-12-25 12:00:00', '2023-12-01 12:00:00');


INSERT INTO secret_santa_draw_participant(secret_santa_id, participant_id, gift_suggestions)
VALUES (1, 1, 'Books, Chocolates')
,(1, 2, 'Board Games, Puzzles')
,(1, 3, 'Coffee, Tea')
,(1, 4, 'Candles, Perfume')
,(1, 5, 'Wine, Cheese')
,(1, 6, 'Books, Coffee')
,(1, 7, 'Chocolates, Wine')
,(1, 8, 'Puzzles, Board Games')
,(1, 9, 'Perfume, Candles')
,(1, 10, 'Cheese, Tea')
;