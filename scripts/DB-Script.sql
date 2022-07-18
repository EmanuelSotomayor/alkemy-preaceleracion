CREATE DATABASE IF NOT EXISTS `alkDB`;

USE alkDB;

CREATE TABLE `characters`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(45) NOT NULL,
    `age` INT NOT NULL,
    `weight` FLOAT NOT NULL,
    `history` TEXT NOT NULL,
    `image` VARCHAR(255) NOT NULL
);

CREATE TABLE `movies_series`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `title` VARCHAR(100) NOT NULL,
    `creation_date` DATE NOT NULL,
    `calification` INT NOT NULL,
    `image` VARCHAR(255) NOT NULL
);

CREATE TABLE `genres`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    `image` VARCHAR(255) NOT NULL
);

CREATE TABLE `movies_series_characters`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`id_character` BIGINT(20) NOT NULL,
    `id_movie_serie` BIGINT(20) NOT NULL,
    CONSTRAINT `fk_movies_series_characters` FOREIGN KEY(`id_character`) REFERENCES `characters`(`id`),
    CONSTRAINT `fk_movies_series` FOREIGN KEY(`id_movie_serie`) REFERENCES `movies_series`(`id`)
);

CREATE TABLE `movies_series_genres`(
	`id` BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
	`id_genre` BIGINT(20) NOT NULL,
    `id_movie_serie` BIGINT(20) NOT NULL,
    CONSTRAINT `fk_movies_series_genres_genres` FOREIGN KEY(`id_genre`) REFERENCES `genres`(`id`),
    CONSTRAINT `fk_movies_series_genres_series` FOREIGN KEY(`id_movie_serie`) REFERENCES `movies_series`(`id`)
);