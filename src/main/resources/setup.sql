-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema bank
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `bank` DEFAULT CHARACTER SET utf8 ;
USE `bank` ;

-- -----------------------------------------------------
-- Table `bank`.`kunde`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`kunde` (
                                              `kunde_id` INT NOT NULL,
                                              `kunde_navn` VARCHAR(45) NOT NULL,
                                              `kunde_by` VARCHAR(45) NOT NULL,
                                              PRIMARY KEY (`kunde_id`))
    ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `bank`.`transaktion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `bank`.`transaktion` (
                                                    `transaktion_id` INT NOT NULL,
                                                    `beløb` INT NULL,
                                                    `dato` DATE NOT NULL,
                                                    `kunde_kunde_id` INT NOT NULL,
                                                    PRIMARY KEY (`transaktion_id`, `kunde_kunde_id`),
                                                    INDEX `fk_transaktion_kunde_idx` (`kunde_kunde_id` ASC) VISIBLE,
                                                    CONSTRAINT `fk_transaktion_kunde`
                                                        FOREIGN KEY (`kunde_kunde_id`)
                                                            REFERENCES `bank`.`kunde` (`kunde_id`)
                                                            ON DELETE NO ACTION
                                                            ON UPDATE NO ACTION)
    ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;