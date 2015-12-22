package es.ubiqua.nhservices.model;

import java.sql.Timestamp;

public class WakeUpAlarm {
	
	private int id;
	private int room;
	private Timestamp setedTime;
	private Timestamp wakeUpTime;
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
