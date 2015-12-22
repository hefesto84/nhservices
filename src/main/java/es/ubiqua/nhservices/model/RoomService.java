package es.ubiqua.nhservices.model;

import java.util.ArrayList;
import java.util.List;

public class RoomService {
	
	private List<Product> products = new ArrayList<Product>();

	public void addProduct(Product p){
		products.add(p);
	}
	
	public void delProduct(Product p){
		products.remove(p);
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}
	
	
}
