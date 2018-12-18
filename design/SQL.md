```sql
-- User Login Table
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `username` varchar(255) NOT NULL,
  `password` varchar(32) DEFAULT NULL,
  `salt` varchar(32) DEFAULT NULL,
  `completeness` tinyint(1) unsigned zerofill DEFAULT '0',
  `register_date` datetime DEFAULT NULL,
  `last_login_date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- User Info Table
CREATE TABLE `table_personal_info` (
  `id` bigint(20) NOT NULL,
  `birth_date` varchar(10) DEFAULT NULL,
  `college` varchar(255) DEFAULT NULL,
  `first_name` varchar(255) DEFAULT NULL,
  `gender` char(1) DEFAULT NULL,
  `last_name` varchar(255) DEFAULT NULL,
  `major` varchar(30) DEFAULT NULL,
  `nick_name` varchar(255) DEFAULT NULL,
  `phone_number` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) references user(`id`)
    on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- User Preference Table
create table `user_preference` (
  `id` bigint(20) NOT NULL,
  `sports` boolean default false,
  `music` boolean default false,
  `technology` boolean default false,
  `politics` boolean default false,
  `art` boolean default false,
  `literature` boolean default false,
  `game` boolean default false,
  `movie` boolean default false,
  `cooking` boolean default false,
  `finance` boolean default false,
  PRIMARY KEY (`id`),
  FOREIGN KEY (`id`) references user(`id`)
    on delete cascade
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Trigger --
-- Add basic infomations after creating a user
DELIMITER $$
create trigger createUserPreference
after insert on user for each row
BEGIN
	insert into user_preference(id) values(new.id);
	insert into table_personal_info(id) values(new.id);
END$$
DELIMITER ;
```

