package com.qa.ims.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.dao.OrderDAO;
import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.Utils;

/**
 * Takes in order details for CRUD functionality
 *
 */
public class OrderController implements CrudController<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();

	private OrderDAO orderDAO;
	private Utils utils;
	
	public OrderController (OrderDAO orderDAO, Utils utils) {
		super();
		this.orderDAO = orderDAO;
		this.utils = utils;
	}
	
	/**
	 * Reads all orders to the logger
	 */
	@Override
	public List<Order> readAll() {
		List<Order> orders = orderDAO.readAll();
		for (Order order : orders) {
			LOGGER.info(order.toString());
		}
		return orders;
	}
	
	/**
	 * Creates an order by taking in user input
	 */
	@Override
	public Order create() {
		LOGGER.info("Please enter the customer id");
		Long customer_id = utils.getLong();
		Boolean addItem = true;
		List<Long> item_id = new ArrayList <>();
		while (addItem) {
			LOGGER.info("Would you like to add an item to the order? ");			
			if (utils.getString() == "yes") {
				LOGGER.info("Please enter the item id you would like to add to the order");
				item_id.add(utils.getLong());
			} else addItem = false;		
		}
		Order order = orderDAO.create(new Order(customer_id, item_id));
		LOGGER.info("Order placed");
		return order;
	}
	
	/**
	 * Updates an existing order by taking in user input
	 */
	@Override
	public Order update() {
		LOGGER.info("Please enter the id of the order you would like to update");
		Long order_id = utils.getLong();
		LOGGER.info("Please enter a customer id");
		Long customer_id = utils.getLong();
		List<Long> item_id = new ArrayList <>();
		Boolean addItem = true;
		while (addItem) {
			LOGGER.info("Would you like to add an item to the order? ");
			String addOrNot = utils.getString();
			if (addOrNot == "yes") {
				LOGGER.info("Please enter the item id you would like to add to the order");
				item_id.add(utils.getLong());
			} else addItem = false;	
		}
		
		Order order = orderDAO.update(new Order(order_id, customer_id, item_id));
		LOGGER.info("Order Updated");
		return order;
	}
	
	/**
	 * Deletes an order using the order id
	 * 
	 * @return
	 */
	@Override
	public int delete() {
		LOGGER.info("Please enter the id of the order you would like to delete");
		Long order_id = utils.getLong();
		return orderDAO.delete(order_id);
	}


}
