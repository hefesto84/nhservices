package es.ubiqua.nhservices.model;

import java.util.List;

public class RoomServiceRequest {
	
	private String hour;
	private String min;
	private int room;
	private List<RoomServiceRequestProduct> products;
	private String comments;
	private int people;
	
	public String getHour() {
		return hour;
	}
	
	public void setHour(String hour) {
		this.hour = hour;
	}
	
	public String getMin() {
		return min;
	}
	
	public void setMin(String min) {
		this.min = min;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public List<RoomServiceRequestProduct> getProducts() {
		return products;
	}
	
	public void setProducts(List<RoomServiceRequestProduct> products) {
		this.products = products;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

}
