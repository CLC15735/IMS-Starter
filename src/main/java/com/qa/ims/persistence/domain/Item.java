package com.qa.ims.persistence.domain;

public class Item {
	
	private Long item_id;
	private String name;
	private float price;
	
	public Item (String name, float price) {
		this.setName(name);
		this.setPrice(price);		
	}
	
	public Item (Long item_id, String name, float price) {
		this.setItem_id(item_id);
		this.setName(name);
		this.setPrice(price);		
	}

	public Long getItem_id() {
		return item_id;
	}

	public void setItem_id(Long item_id) {
		this.item_id = item_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}
	
	@Override
	public String toString() {
		return "item id: "+ item_id + " name: " + name + " price: " + price; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 2;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		//result = prime * result + ((price == 0) ? 0 : price.hashCode()); Primitive types do not have methods
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		//What does this THIS refers to?
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		//Ask what is this doing
		Item other = (Item) obj;
		if (item_id == null) {
			if (other.item_id != null) return false;
		}	
			else if (!item_id.equals(other.item_id)) return false;
		
		if (name == null) {
			if (other.name != null) return false; 
		}
		else if (!name.equals(other.name)) return false;
		
		if (getPrice()==0) {
			if (other.getPrice() != 0) return false;		
		}
		else if (!(price == other.price)) return false;
		
		return true;		
	}

}
