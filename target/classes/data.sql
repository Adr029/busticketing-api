INSERT IGNORE INTO availabletrips (departuredate, departureTime, origin, destination, availableseats, bustype, distance) VALUES
('2024-01-04', '12:00 PM', 'Cubao', 'Baguio', 50, 1, 247),
('2024-01-04', '01:00 PM', 'Cubao', 'Baguio', 50, 2, 247),
('2024-01-04', '03:00 PM', 'Cubao', 'Baguio', 50, 3, 247),
('2024-01-04', '05:00 PM', 'Cubao', 'Baguio', 50, 0, 247),
('2024-01-05', '07:00 AM', 'Cubao', 'Baguio', 50, 0, 247),
('2024-01-05', '08:00 AM', 'Cubao', 'Baguio', 50, 0, 247),
('2024-01-05', '10:00 PM', 'Cubao', 'Baguio', 50, 2, 247);




INSERT IGNORE INTO reservedtrips (id, ticketnumber, quantity, tripid, firstname, lastname, notes, date, time, fare) VALUES
(1, 1001, 1, 1, 'John', 'Doe', 'Special request', '2022-01-15', '14:30:00', 572.2),
(2, 1002, 2, 2, 'Jane', 'Smith', 'No preferences', '2022-02-05', '10:45:00', 572.2),
(3, 1003, 1, 2, 'Michael', 'Johnson', NULL, '2022-03-20', '18:15:00', 572.2),
(4, 1004, 1, 4, 'Emily', 'Williams', 'Allergies: Nuts', '2022-04-10', '12:00:00', 572.2),
(5, 1005, 1, 3, 'David', 'Jones', 'Window seat requested', '2022-05-02', '08:30:00', 572.2),
(6, 1006, 2, 6, 'Sophia', 'Brown', NULL, '2022-06-15', '16:45:00', 572.2),
(7, 1007, 1, 7, 'Matthew', 'Davis', 'Extra legroom', '2022-07-08', '20:00:00', 572.2),
(8, 1008, 1, 1, 'Olivia', 'Miller', 'No preferences', '2022-08-19', '09:30:00', 572.2),
(9, 1009, 1, 2, 'Daniel', 'Wilson', NULL, '2022-09-25', '14:00:00', 572.2),
(10, 1010, 2, 4, 'Emma', 'Moore', 'Allergies: Shellfish', '2022-10-12', '17:30:00', 572.2);

