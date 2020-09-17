DROP TABLE IF EXISTS `customers`;
CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) NULL DEFAULT NULL,
    `surname` VARCHAR(40) NULL DEFAULT NULL,
    PRIMARY KEY (`id`)
);
DROP TABLE IF EXISTS `items`;
CREATE TABLE IF NOT EXISTS `items` (
    `item_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(40) NULL DEFAULT NULL,
    `category` VARCHAR(40) NULL DEFAULT NULL,
    `price` FLOAT NULL DEFAULT NULL,
    PRIMARY KEY (`item_id`)
);

DROP TABLE IF EXISTS `orders`;
CREATE TABLE IF NOT EXISTS `orders` (
    `order_id` INT(11) NOT NULL AUTO_INCREMENT,
    `customer_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`order_id`),
    FOREIGN KEY (`customer_id`) REFERENCES customers (`id`)
);

DROP TABLE IF EXISTS `orders_items`;
CREATE TABLE IF NOT EXISTS `orders_items` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `order_id` INT(11) DEFAULT NULL,
    `item_id` INT(11) DEFAULT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`order_id`) REFERENCES orders (`order_id`),
    FOREIGN KEY (`item_id`) REFERENCES items (`item_id`)
);