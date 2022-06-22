CREATE TABLE `company_employees` (
                                     `id` int(11) NOT NULL AUTO_INCREMENT,
                                     `company_id` int(11),
                                     `employees_id` int(11),
                                     PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
