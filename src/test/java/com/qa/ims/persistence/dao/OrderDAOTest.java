package com.qa.ims.persistence.dao;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.qa.ims.persistence.domain.Order;
import com.qa.ims.utils.DBUtils;

public class OrderDAOTest {
	
	private final OrderDAO DAO = new OrderDAO();
	
	@Before
	public void setup() {
		DBUtils.connect("src/test/resources/db.properties");
		DBUtils.getInstance().init("src/test/resources/sql-schema2.sql", "src/test/resources/sql-data2.sql");
	}
	
	@Test
	public void testCreate() {
		List<Long> populate = new ArrayList <>();
		populate.add(1L);
		final Order created = new Order (2L, 1L, populate);
		assertEquals(created, DAO.create(created));
	}
	
	@Test
	public void testReadAll() {
		List<Order> expected = new ArrayList<>();
		List<String> populateItem = new ArrayList <>();
		populateItem.add("Ball");
		List<Float> populatePrice = new ArrayList <>();
		populatePrice.add(23.4f);
		expected.add(new Order(1L,"jordan", populateItem, populatePrice));
		assertEquals(expected, DAO.readAll());
	}
	
	@Test
	public void testReadLatest() {
		List<Long> populate = new ArrayList <>();
		populate.add(1L);
		assertEquals(new Order(1L, 1L, populate), DAO.readLatest());
	}
	
	@Test
	public void testRead() {
		final long ID = 1L;
		List<Long> populate = new ArrayList <>();
		populate.add(1L);
		assertEquals(new Order(ID, 1L, populate), DAO.readOrder(ID));
	}

	@Test
	public void testUpdate() {
		List<Long> populate = new ArrayList <>();
		populate.add(1L);
		
		final Order created = new Order (1L, 2L, populate);
		
		assertEquals(created, DAO.update(created));
	}

	@Test
	public void testDelete() {
		assertEquals(0, DAO.delete(1));
	}

	
}
