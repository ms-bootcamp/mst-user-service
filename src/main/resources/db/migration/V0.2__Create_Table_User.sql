CREATE TABLE `t_user` (
  `id`                VARCHAR(255) NOT NULL PRIMARY KEY,
  `name`              VARCHAR(255) NOT NULL,
  `password`          VARCHAR(255) NOT NULL,
  `role`              VARCHAR(255) NOT NULL,
  FOREIGN KEY (`role`) REFERENCES `t_role` (`symbol`),
  UNIQUE KEY `uk_name` (`name`)
);