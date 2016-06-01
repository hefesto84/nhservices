package es.ubiqua.nhservices.model;

import java.util.List;

public class RoomServiceRequestProduct {
	
	private int id;
	private int quantity;
	private String ingredients;
	private List<RoomServiceRequestProductQuestions> questions;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public int getQuantity() {
		return quantity;
	}
	
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getIngredients() {
		return ingredients;
	}

	public void setIngredients(String ingredients) {
		this.ingredients = ingredients;
	}

	public List<RoomServiceRequestProductQuestions> getQuestions() {
		return questions;
	}

	public void setQuestions(List<RoomServiceRequestProductQuestions> questions) {
		this.questions = questions;
	}
	
}
