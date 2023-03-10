/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Xavier
 * Created: 28-Feb-2023
 */

DROP SCHEMA IF EXISTS `userdb`;
CREATE SCHEMA IF NOT EXISTS `userdb` DEFAULT CHARACTER SET latin1;
USE `userdb`;

CREATE TABLE IF NOT EXISTS `userdb`.`role` (
  `role_id` INT(11) NOT NULL,
  `role_name` VARCHAR(25) NOT NULL,
  PRIMARY KEY (`role_id`));

CREATE TABLE IF NOT EXISTS `userdb`.`user` (
  `email` VARCHAR(40) NOT NULL,
  `first_name` VARCHAR(20) NOT NULL,
  `last_name` VARCHAR(20) NOT NULL,
  `password` VARCHAR(20) NOT NULL,
  `role` INT(11) NOT NULL,
  PRIMARY KEY (`email`),
  CONSTRAINT `fk_user_role`
    FOREIGN KEY (`role`)
    REFERENCES `userdb`.`role` (`role_id`));


INSERT INTO `role` VALUES (1, 'system admin');
INSERT INTO `role` VALUES (2, 'regular user');

INSERT INTO `user` (`email`,`first_name`,`last_name`,`password`,`role`)
	VALUES ('cprg352+admin@gmail.com', 'Admin','Admin', 'password', 1);
INSERT INTO `user` (`email`,`first_name`,`last_name`,`password`,`role`)
	VALUES ('cprg352+admin2@gmail.com', 'Admin2','Admin2', 'password', 1);
INSERT INTO `user` (`email`,`first_name`,`last_name`,`password`,`role`)
	VALUES ('cprg352+anne@gmail.com', 'Anne','Annerson', 'password', 2);
INSERT INTO `user` (`email`,`first_name`,`last_name`,`password`,`role`)
	VALUES ('cprg352+barb@gmail.com', 'Barb','Barber', 'password', 2);

