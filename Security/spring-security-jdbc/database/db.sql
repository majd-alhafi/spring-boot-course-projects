-- Create the database
CREATE DATABASE demo;
USE demo;
-- Create the users table
CREATE TABLE users (
                       username VARCHAR(255) NOT NULL PRIMARY KEY,
                       password VARCHAR(255) NOT NULL,
                       enabled BOOLEAN NOT NULL
);

-- Create the authorities table
CREATE TABLE authorities (
                             username VARCHAR(255) NOT NULL,
                             authority VARCHAR(50) NOT NULL,
                             CONSTRAINT fk_authorities_users FOREIGN KEY (username) REFERENCES users(username)
);