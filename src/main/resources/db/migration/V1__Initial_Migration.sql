-- -----------------------------------------------------
-- Database example
-- -----------------------------------------------------
CREATE DATABASE IF NOT EXISTS example DEFAULT CHARACTER SET utf8 ;

-- -----------------------------------------------------
-- Schema example
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS example DEFAULT CHARACTER SET utf8 ;
USE example ;

-- -----------------------------------------------------
-- Table example.authority_group
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS example.authority_group (
  id INT NOT NULL AUTO_INCREMENT,
  created_by VARCHAR(45) NULL,
  created_date TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  name VARCHAR(45) NOT NULL,
  description VARCHAR(45) NULL,
  PRIMARY KEY (id))
ENGINE = InnoDB;
