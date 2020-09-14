package com.qa.ims.persistence.domain;

public class Item {
	
	private Long item_id;
	private String name;
	private String category;
	private float price;
	
	public Item (String name, String category, Float price) {
		this.setName(name);
		this.setCategory(category);
		this.setPrice(price);
	}
	
	public Item (Long item_id, String name, String category, Float price) {
		this.setItem_id(item_id);
		this.setName(name);
		this.setCategory(category);	
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

	
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "item id: "+ item_id + " name: " + name + " category: " + category + " price: " + price; 
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 2;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((item_id == null) ? 0 : item_id.hashCode());
		result = prime * result + ((category == null) ? 0 : category.hashCode()); 
		result = prime * result + ((price == +0f) ? 0 : Float.floatToIntBits(price));
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
		Item other = (Item) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (item_id == null) {
			if (other.item_id != null)
				return false;
		} else if (!item_id.equals(other.item_id))
			return false;
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (price == 0) {
			if (other.price != 0)
				return false;
		} else if (!(Float.compare(price,other.price) == 0))
			return false;
		return true;
	}

}
