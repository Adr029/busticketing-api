INSERT IGNORE INTO availabletrips (departuredate, departureTime, origin, destination, availableseats, bustype, distance) VALUES
('2024-01-04', '12:00 PM', 'Cubao', 'Baguio', 50, 1, 247),
('2024-01-04', '01:00 PM', 'Cubao', 'Baguio', 50, 2, 247),
('2024-01-04', '03:00 PM', 'Cubao', 'Baguio', 50, 3, 247),
('2024-01-04', '05:00 PM', 'Cubao', 'Baguio', 50, 0, 247),
('2024-01-05', '07:00 AM', 'Cubao', 'Baguio', 50, 0, 247),
('2024-01-05', '08:00 AM', 'Cubao', 'Baguio', 50, 0, 247),
('2024-01-05', '10:00 PM', 'Cubao', 'Baguio', 50, 2, 247);



INSERT IGNORE INTO reservedtrips (ticketnumber, quantity, tripid, firstname, lastname, notes, date, time, fare) VALUES
('ABC12345', 1, 1, 'John', 'Doe', 'Special request', '2022-01-15', '14:30:00', 572.2),
('XYZ67890', 2, 2, 'Jane', 'Smith', 'No preferences', '2022-02-05', '10:45:00', 572.2),
('PQR56789', 1, 2, 'Michael', 'Johnson', NULL, '2022-03-20', '18:15:00', 572.2),
('LMN45678', 1, 4, 'Emily', 'Williams', 'Allergies: Nuts', '2022-04-10', '12:00:00', 572.2),
('DEF23456', 1, 3, 'David', 'Jones', 'Window seat requested', '2022-05-02', '08:30:00', 572.2),
('GHI78901', 2, 6, 'Sophia', 'Brown', NULL, '2022-06-15', '16:45:00', 572.2),
('JKL01234', 1, 7, 'Matthew', 'Davis', 'Extra legroom', '2022-07-08', '20:00:00', 572.2),
('MNO12345', 1, 1, 'Olivia', 'Miller', 'No preferences', '2022-08-19', '09:30:00', 572.2),
('QRS45678', 1, 2, 'Daniel', 'Wilson', NULL, '2022-09-25', '14:00:00', 572.2),
('TUV56789', 2, 4, 'Emma', 'Moore', 'Allergies: Shellfish', '2022-10-12', '17:30:00', 572.2);