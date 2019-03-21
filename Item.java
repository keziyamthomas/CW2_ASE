package model;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Item {
	private String itemName;
	private String description;
	private double price;
	private String category;
	private String id;
	private int cookTimeMS;
	
	public Item(String itemName, String description, double price, String category, String id,int cookTimeMS) throws PatternException{
		if(!match(id)) {
			throw new PatternException("The item id should have the following pattern: BIT / HOT / SHK / CCD and <a 3-digit number> eg.CUST123");
		}
		else {
			this.itemName = itemName;
			this.description = description;
			this.price = price;
			this.category = category;
			this.id = id;
			this.cookTimeMS=cookTimeMS;
		}
	}
	
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public int getCookTimeMS() {
		return cookTimeMS;
	}
	public void setCookTimeMS(int cookTimeMS) {
		this.cookTimeMS = cookTimeMS;
	}
	public boolean match(String id) {
		String pattern = "BIT|HOT|SHK|CCD\\d{3}";
		Pattern pat = Pattern.compile(pattern);
		Matcher m = pat.matcher(id);
		return m.find();
	}

}
