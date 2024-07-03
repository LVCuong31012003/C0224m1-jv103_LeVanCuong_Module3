CREATE DATABASE demo;
use demo;

CREATE TABLE Student (
Sid INT NOT NULL PRIMARY KEY,
Sname varchar(255)
);

CREATE TABLE Teacher (
Tid INT NOT NULL PRIMARY KEY,
Tname varchar(255),
Tage INT NOT NULL,
Tcountry varchar(255)
);

