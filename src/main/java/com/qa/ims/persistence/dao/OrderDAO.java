package com.qa.ims.persistence.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAO implements Dao<Order> {
	
	public static final Logger LOGGER = LogManager.getLogger();


	
	@Override
	public Order modelFromResultSet(ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		String customerName = resultSet.getString("first_name");
		List<String> itemName = new ArrayList <>();
		itemName.add(resultSet.getString("name"));
		return new Order (order_id, customerName, itemName);
	}
	
	@Override 
	public Order model2 (ResultSet resultSet) throws SQLException {
		Long order_id = resultSet.getLong("order_id");
		Long customer_id = resultSet.getLong("customer_id");
		List<Long> item_id = new ArrayList <>();
		item_id.add(resultSet.getLong("item_id"));
		
		return new Order (order_id, customer_id, item_id);
	}
	
	/**
	 * Reads all orders from the database matching the customer
	 * 
	 * @return A list of orders
	 */
	@Override
	public List<Order> readAll() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				//ResultSet resultSet = statement.executeQuery("SELECT o.order_id, o.customer_id, oi.item_id, price FROM orders o JOIN orders_items oi JOIN items ON o.order_id = oi.order_id AND oi.item_id = items.item_id");)
				ResultSet resultSet = statement.executeQuery("SELECT o.order_id, c.first_name, i.name FROM orders o JOIN customers c JOIN items i JOIN orders_items oi WHERE o.order_id = oi.order_id AND oi.item_id = i.item_id AND c.id = o.customer_id ORDER BY o.order_id");) {
					List<Order> order = new ArrayList<>();
						while (resultSet.next()) {
							order.add(modelFromResultSet(resultSet));
						}
					return order;
				} catch (SQLException e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return new ArrayList<>();
	}

	public Order readLatest() {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.order_id, customer_id, item_id FROM orders o JOIN orders_items ORDER BY o.order_id DESC LIMIT 1");) {
			resultSet.next();
			return model2(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	/**
	 * Creates an order in the database
	 * 
	 * @param order - takes in an order object. order_id will be ignored
	 */
	@Override
	public Order create(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
		
				Statement statement = connection.createStatement();) {
			
			statement.executeUpdate("INSERT INTO orders(customer_id) VALUES('" + order.getCustomer_id()
					+ "')");
			
			ResultSet resultSet = statement.executeQuery("SELECT * FROM orders ORDER BY order_id DESC LIMIT 1");
			resultSet.next();
			Long order_id = resultSet.getLong("order_id");

			for (int i=0; i<order.getItem_id().size(); i++) {
				statement.executeUpdate("INSERT INTO orders_items(order_id, item_id) VALUES ('" + order_id + "','" + order.getItem_id().get(i) + "')");
			}
			
			return readLatest();
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}

	public Order readOrder(Long order_id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();
				ResultSet resultSet = statement.executeQuery("SELECT o.order_id, o.customer_id, oi.item_id FROM orders o JOIN orders_items oi ON o.order_id = oi.order_id WHERE o.order_id = " + order_id);) {
			resultSet.next();
			return model2(resultSet);
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return null;
	}
	
	/**
	 * Updates an order in the database
	 * 
	 * @param order - takes in an order object, the order_id field will be used to
	 *                 update that customer in the database
	 * @return
	 */
	@Override
	public Order update(Order order) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
				
				statement.executeUpdate("UPDATE orders SET customer_id ='" + order.getCustomer_id()+ "' where order_id =" + order.getOrder_id());
			
				Long order_id = order.getOrder_id();
				for (int i=0; i<order.getItem_id().size(); i++) {
					statement.executeUpdate("INSERT INTO orders_items(order_id, item_id) VALUES ('" + order_id + "','" + order.getItem_id().get(i) + "')");
				}
				
			return readOrder(order.getOrder_id());
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
			}
		return null;
	}
	
	/**
	 * Deletes an order in the database
	 * 
	 * @param id - id of the order
	 */
	@Override
	public int delete(long id) {
		try (Connection connection = DBUtils.getInstance().getConnection();
				Statement statement = connection.createStatement();) {
				statement.executeUpdate("DELETE FROM orders_items WHERE order_id = " + id);
				statement.executeUpdate("DELETE FROM orders WHERE order_id = " + id);
				
							
		} catch (Exception e) {
			LOGGER.debug(e);
			LOGGER.error(e.getMessage());
		}
		return 0;
	}


}
