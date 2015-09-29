# mini_articles
A small version of a simple blog.

You must create a database with the name articledb and four tables:

CREATE TABLE `articledb`.`article` (
  `id` INT NULL AUTO_INCREMENT,
  `title` VARCHAR(100) NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `content` VARCHAR(4000) NOT NULL,
  `date_creating` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`));
  
  CREATE TABLE `articledb`.`comments` (
  `id` INT NULL AUTO_INCREMENT,
  `articleid` INT NOT NULL,
  `author` VARCHAR(45) NOT NULL,
  `date` TIMESTAMP NOT NULL,
  `content` VARCHAR(1000) NOT NULL,
  PRIMARY KEY (`id`));

  CREATE TABLE `articledb`.`user_roles` (
  `user_role_id` INT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`user_role_id`));
  
  CREATE TABLE `articledb`.`users` (
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `enabled` SMALLINT NOT NULL,
  PRIMARY KEY (`username`));
