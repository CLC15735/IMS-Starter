INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Jordan', 'Harrison');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Cristina', 'López');
INSERT INTO `ims`.`customers` (`first_name`, `surname`) VALUES ('Enrique', 'Niño');

INSERT INTO `ims`.`items` (`name`,`category`, `price` ) VALUES ('Ball', 'Sports', 23.4);
INSERT INTO `ims`.`items` (`name`,`category`, `price` ) VALUES ('Hat', 'Clothing', 13.75);
INSERT INTO `ims`.`items` (`name`,`category`, `price` ) VALUES ('Earrings', 'Accessories', 10.0);

INSERT INTO `ims`.`orders` (`customer_id`) VALUES (1);
INSERT INTO `ims`.`orders_items` (`order_id`,`item_id`) VALUES (1,2);
INSERT INTO `ims`.`orders` (`customer_id`) VALUES (3);
INSERT INTO `ims`.`orders_items` (`order_id`,`item_id`) VALUES (2,2);
INSERT INTO `ims`.`orders_items` (`order_id`,`item_id`) VALUES (2,1);
INSERT INTO `ims`.`orders` (`customer_id`) VALUES (1);
INSERT INTO `ims`.`orders_items` (`order_id`,`item_id`) VALUES (3,1);
