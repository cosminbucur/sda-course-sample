CREATE TABLE `spring_security_jdbc`.`app_user` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `password` VARCHAR(80) NOT NULL,
  `enabled` BIT(1) NOT NULL,
  `role` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NULL,
  `created` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`));
