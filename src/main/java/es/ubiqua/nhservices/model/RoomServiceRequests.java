package es.ubiqua.nhservices.model;

import java.util.Date;

public class RoomServiceRequests {
	private int id;
	private Date nowTime;
	private Date requestTime;
	private int room;
	private String products;
	private String comments;
	private int people;
	private String randomId;
	private Boolean actived;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getNowTime() {
		return nowTime;
	}
	
	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}
	
	public Date getRequestTime() {
		return requestTime;
	}
	
	public void setRequestTime(Date date) {
		this.requestTime = date;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}
	
	public String getProducts() {
		return products;
	}
	
	public void setProducts(String products) {
		this.products = products;
	}

	public String getRandomId() {
		return randomId;
	}

	public void setRandomId(String randomId) {
		this.randomId = randomId;
	}

	public Boolean getActived() {
		return actived;
	}

	public void setActived(Boolean actived) {
		this.actived = actived;
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
