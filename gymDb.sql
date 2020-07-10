DROP DATABASE IF EXISTS gymDb;
CREATE DATABASE gymDb;
USE gymDb;

DROP TABLE IF EXISTS Clients;
CREATE TABLE Clients(
       clientID INT NOT NULL auto_increment,
       fName VARCHAR(20) NOT NULL,
       lName VARCHAR(30) NOT NULL,
       email VARCHAR(70) NOT NULL,
       PRIMARY KEY (clientID)
);

DROP TABLE IF EXISTS Staff;
CREATE TABLE Staff(
	staffID INT NOT NULL auto_increment,
	fName VARCHAR(20) NOT NULL,
	lName VARCHAR(30) NOT NULL,
	PRIMARY KEY (staffID)
);


DROP TABLE IF EXISTS staffSpecifications;
CREATE TABLE staffSpecifications(
       specID INT NOT NULL auto_increment,
       staffID INT NOT NULL,
       specification VARCHAR(30) NOT NULL,
       PRIMARY KEY (specID, staffID),
       FOREIGN KEY (staffID) REFERENCES Staff(staffID)
);

DROP TABLE IF EXISTS Bookings;
CREATE TABLE Bookings(
       bookingID INT NOT NULL auto_increment,
       staffID INT NOT NULL,
       clientID INT NOT NULL,
       focus ENUM('WeightLoss', 'Strength', 'HealthMaintenance', 'Flexibility') NOT NULL,
       bkDate DATE NOT NULL,
       bkTime TIME NOT NULL,
       duration INT(3) NOT NULL,
       PRIMARY KEY (bookingID, staffID, clientID),
       FOREIGN KEY (staffID) REFERENCES Staff(staffID),
       FOREIGN KEY (clientID) REFERENCES Clients(clientID)
);


INSERT INTO Clients (fName, lName, email) VALUE ('Marc', 'Walker', 'marc123@gmail.com'),
('Paul', 'Runner', 'runnerP@yahoo.com'),
('Emanuel', 'Ecase', 'emanuel@gmail.com'),
('Laura', 'Orac', 'laura19@gmail.com'),
('Kacper', 'Tudor', 'KacTud@gmail.com');

INSERT INTO Staff (fName, lName) VALUE ('Ali', 'Bee'),
('Peter', 'Lopez'),
('Maxim', 'Verstapen'),
('Lukas', 'Petrov'),
('Robert', 'Omar');

INSERT INTO staffSpecifications (staffID,specification) VALUE ('1', 'WeightLoss'),
('1', 'HealthMaintenance'),
('2', 'Flexibility'),
('3', 'Strength'),
('4', 'Strength'),
('4', 'HealthMaintenance'),
('5', 'WeightLoss');


INSERT INTO Bookings (staffID, clientID, focus, bkDate, bkTime, duration) 
VALUES ('2', '1', 'Flexibility', '2020-03-01', '10:00:00', 60),
('1', '2', 'HealthMaintenance', '2020-03-04', '16:00:00', 45),
('5', '4', 'Strength', '2020-02-14', '15:00:00', 90),
('3', '5', 'WeightLoss', '2020-02-18', '09:00:00', 60),
('4', '3', 'Strength', '2020-02-04', '08:00:00', 90);
