package es.ubiqua.nhservices.model;

import java.sql.Date;

public class BreakfastRequests {
	
	private int id;
	private Date dia;
	private Boolean actived;
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public Date getDia() {
		return dia;
	}
	
	public void setDia(Date dia) {
		this.dia = dia;
	}
	
	public Boolean getActived() {
		return actived;
	}
	
	public void setActived(Boolean actived) {
		this.actived = actived;
	}

}
