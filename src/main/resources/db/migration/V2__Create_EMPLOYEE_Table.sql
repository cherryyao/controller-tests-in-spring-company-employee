CREATE TABLE `employee`(
    `employee_id` BIGINT  NOT NULL AUTO_INCREMENT PRIMARY KEY,
    `company_id` BIGINT,
    `name` VARCHAR(64) NOT NULL,
    `gender` VARCHAR(20) NOT NULL,
    `created_date` TIMESTAMP DEFAULT NOW()
);