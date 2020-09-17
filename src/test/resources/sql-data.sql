INSERT INTO `customers` (`first_name`, `surname`) VALUES ('jordan', 'harrison');
INSERT INTO `items` (`name`,`category`, `price` ) VALUES ('Ball', 'Sports', 23.4);
INSERT INTO `orders` (`customer_id`) VALUES (1);
INSERT INTO `orders_items` (`order_id`,`item_id`) VALUES (1,2);