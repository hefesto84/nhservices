package es.ubiqua.nhservices.model;

import java.sql.Timestamp;
import java.util.Date;

public class WakeUpAlarm {
	
	private int id;
	private int room;
	private Date setedTime;
	private Date wakeUpTime;
	private String randomId;
	private Boolean actived;
	
	public int getId() {
		return id;
	}
	
	public int getRoom() {
		return room;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	
	public void setRoom(int room) {
		this.room = room;
	}

	
	/*
	public Timestamp getSetedTime() {
		return setedTime;
	}

	public void setSetedTime(Timestamp setedTime) {
		this.setedTime = setedTime;
	}

	public Timestamp getWakeUpTime() {
		return wakeUpTime;
	}

	public void setWakeUpTime(Timestamp wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
	}

	*/
	
	public Date getSetedTime() {
		return setedTime;
	}

	public Date getWakeUpTime() {
		return wakeUpTime;
	}

	public void setSetedTime(Date setedTime) {
		this.setedTime = setedTime;
	}

	public void setWakeUpTime(Date wakeUpTime) {
		this.wakeUpTime = wakeUpTime;
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

}
