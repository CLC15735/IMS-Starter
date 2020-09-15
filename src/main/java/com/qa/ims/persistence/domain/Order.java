package com.qa.ims.persistence.domain;

import java.util.ArrayList;
import java.util.List;

public class Order {
	

	private List<Long> item_id = new ArrayList <>();
	//Each order can have a number of items, and each item can be in a number of orders
	private Long order_id;
	private Long customer_id;
	
	public Order (Long customer_id, List<Long> item_id) {
		this.customer_id = customer_id;
		this.item_id = item_id;
	}
	
	public Order (Long order_id ,Long customer_id, List<Long> item_id) {
		this.order_id = order_id;
		this.customer_id = customer_id;
		this.item_id = item_id;
	}

	public Long getOrder_id() {
		return order_id;
	}

	public void setOrder_id(Long order_id) {
		this.order_id = order_id;
	}

	public Long getCustomer_id() {
		return customer_id;
	}

	public void setCustomer_id(Long customer_id) {
		this.customer_id = customer_id;
	}

		
	public List<Long> getItem_id() {
		return item_id;
	}

	public void setItem_id(List<Long> item_id) {
		this.item_id = item_id;
	}

	@Override
	public String toString() {
		String message = "order ID: " + order_id + " customer reference: " + customer_id + " item reference: " ;
		for (Long i : item_id) message += i + ", ";
		
		return message;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((order_id == null) ? 0 : order_id.hashCode());
		result = prime * result + ((customer_id == null) ? 0 : customer_id.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Order other = (Order) obj;
		
		if (order_id == null) {
			if (other.order_id != null)
				return false;
		} else if (!order_id.equals(other.order_id))
			return false;
		
		if (customer_id == null) {
			if (other.customer_id != null)
				return false;
		} else if (!customer_id.equals(other.customer_id))
			return false;
		
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		
		return true;
	}

}
