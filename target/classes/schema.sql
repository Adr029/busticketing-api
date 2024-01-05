CREATE TABLE IF NOT EXISTS availabletrips (
    id INT AUTO_INCREMENT PRIMARY KEY,
    departuredate VARCHAR(30),
    departuretime VARCHAR(30),
    origin VARCHAR(30),
    destination VARCHAR(30),
    availableseats INT,
    bustype INT,
    distance INT

);


CREATE TABLE IF NOT EXISTS reservedtrips (
    id INT AUTO_INCREMENT PRIMARY KEY,
    ticketnumber INT,
    quantity INT,
    tripid INT,
    firstname VARCHAR(30),
    lastname VARCHAR(30),
    notes VARCHAR(150),
    date VARCHAR(30),
    time VARCHAR(30),
    fare DOUBLE

);

