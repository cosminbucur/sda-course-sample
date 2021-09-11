INSERT INTO `spring_security_jdbc`.`app_user` (`username`, `password`, `enabled`, `role`, `email`)
VALUES ('admin', '{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi', 1, 'ADMIN', 'admin@gmail.com');
INSERT INTO `spring_security_jdbc`.`app_user` (`username`, `password`, `enabled`, `role`, `email`)
VALUES ('user', '{bcrypt}$2y$12$92ZkDrGVS3W5ZJI.beRlEuyRCPrIRlkEHz6T.7MVmH38l4/VAHhyi', 1, 'USER', 'user@gmail.com');