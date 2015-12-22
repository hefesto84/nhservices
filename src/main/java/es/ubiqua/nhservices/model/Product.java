package es.ubiqua.nhservices.model;

public class Product {
	
	private String name;
	private int quantity;
	
	public Product(String name, int quantity){
		this.name = name;
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
	
}