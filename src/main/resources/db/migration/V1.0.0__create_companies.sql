CREATE TABLE `company` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `name` VARCHAR(200),
                           `employee_number` int(11),
                           PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE `employee` (
                           `id` int(11) NOT NULL AUTO_INCREMENT,
                           `age` int(11),
                           `gender` VARCHAR(200),
                           `name` VARCHAR(200),
                           `salary` int(11),
                            PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

