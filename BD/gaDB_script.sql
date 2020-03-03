-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema gaDB
-- -----------------------------------------------------
-- Laboratorio de moviles 01 y 02

-- -----------------------------------------------------
-- Schema gaDB
--
-- Laboratorio de moviles 01 y 02
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `gaDB` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_spanish_ci ;
USE `gaDB` ;

-- -----------------------------------------------------
-- Table `gaDB`.`carrera`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaDB`.`carrera` (
  `codigo` VARCHAR(10) NOT NULL,
  `titulo` VARCHAR(25) NULL,
  `nombre` VARCHAR(100) NULL,
  PRIMARY KEY (`codigo`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gaDB`.`curso`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaDB`.`curso` (
  `codigo` VARCHAR(10) NOT NULL,
  `carrera_codigo` VARCHAR(10) NOT NULL,
  `anio` VARCHAR(15) NULL,
  `ciclo` VARCHAR(15) NULL,
  `nombre` VARCHAR(100) NULL,
  `creditos` INT NULL,
  `horas_semanales` INT NULL,
  PRIMARY KEY (`codigo`, `carrera_codigo`),
  INDEX `fk_curso_carrera_idx` (`carrera_codigo` ASC) VISIBLE,
  CONSTRAINT `fk_curso_carrera`
    FOREIGN KEY (`carrera_codigo`)
    REFERENCES `gaDB`.`carrera` (`codigo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `gaDB`.`usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `gaDB`.`usuario` (
  `cedula` INT NOT NULL,
  `contrasena` VARCHAR(45) NULL,
  `nombre` VARCHAR(45) NULL,
  PRIMARY KEY (`cedula`))
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
