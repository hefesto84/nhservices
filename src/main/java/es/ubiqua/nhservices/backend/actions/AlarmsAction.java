package es.ubiqua.nhservices.backend.actions;

import java.io.InputStream;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.BreakfastServiceRequestsManager;
import es.ubiqua.nhservices.manger.RoomServiceRequestsManager;
import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.BreakfastServiceRequests;
import es.ubiqua.nhservices.model.RoomServiceRequests;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;

public class AlarmsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WakeUpAlarm wakeUpAlarm;
	private RoomServiceRequests roomServiceRequest;
	private BreakfastServiceRequests breakfastServiceRequest;
	private List<WakeUpAlarm> wakeUpAlarms;
	private List<RoomServiceRequests> roomServiceRequests;
	private List<BreakfastServiceRequests> breakfastServiceRequests;
	private int id;
	private String status;
	private InputStream inputStream;
	
	public String breakfastServiceList(){
		
		breakfastServiceRequests = new BreakfastServiceRequestsManager().list();
		
		return SUCCESS;
	}
	
	public String breakfastServiceProductPDF(){
		
		inputStream = null;
		
		breakfastServiceRequest = new BreakfastServiceRequests();
		breakfastServiceRequest.setId(id);
		BreakfastServiceRequestsManager breakfastServiceRequestsManager = new BreakfastServiceRequestsManager();
		breakfastServiceRequest = breakfastServiceRequestsManager.get(breakfastServiceRequest);
		
		inputStream = Utils.breakfastServicePDF(breakfastServiceRequest);
		
		return SUCCESS;
		
	}
	
	public String roomServiceList(){
		
		roomServiceRequests = new RoomServiceRequestsManager().list();
		
		return SUCCESS;
	}
	
	public String roomServiceActivate(){
		
		roomServiceRequest = new RoomServiceRequests();
		roomServiceRequest.setId(id);
		RoomServiceRequestsManager roomServiceRequestsManager = new RoomServiceRequestsManager();
		roomServiceRequest = roomServiceRequestsManager.get(roomServiceRequest);
		roomServiceRequest = roomServiceRequestsManager.confirmRequest(roomServiceRequest);
		
		Utils.stopCronRoomService(roomServiceRequest, "roomService");
		Utils.stopCronNoRespondRoomService(roomServiceRequest, "noRespondRoomService");
		Utils.stopCronRoomServiceTenMinutes(roomServiceRequest, "roomServiceTenMinutes");
				
		status = "ok";
		
		return SUCCESS;
	}
	
	public String roomServiceProductPDF(){
		
		inputStream = null;
		
		roomServiceRequest = new RoomServiceRequests();
		roomServiceRequest.setId(id);
		RoomServiceRequestsManager roomServiceRequestsManager = new RoomServiceRequestsManager();
		roomServiceRequest = roomServiceRequestsManager.get(roomServiceRequest);
		
		inputStream = Utils.roomServicePDF(roomServiceRequest);
		
		return SUCCESS;
		
	}
	
	public String wakeUpList(){
		
		wakeUpAlarms = new WakeUpAlarmManager().listToday();
		
		return SUCCESS;
	}
	
	public String wakeUpActivate(){
		
		wakeUpAlarm = new WakeUpAlarm();
		wakeUpAlarm.setId(id);
		WakeUpAlarmManager wakeUpAlarmManager = new WakeUpAlarmManager();
		wakeUpAlarm = wakeUpAlarmManager.get(wakeUpAlarm);
		wakeUpAlarm = wakeUpAlarmManager.confirmAlarm(wakeUpAlarm);
		
		Utils.stopCron(wakeUpAlarm, "wakeUp");
		
		status = "ok";
		
		return SUCCESS;
	}

	public List<WakeUpAlarm> getWakeUpAlarms() {
		return wakeUpAlarms;
	}

	public void setWakeUpAlarms(List<WakeUpAlarm> wakeUpAlarms) {
		this.wakeUpAlarms = wakeUpAlarms;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<RoomServiceRequests> getRoomServiceRequests() {
		return roomServiceRequests;
	}

	public void setRoomServiceRequests(List<RoomServiceRequests> roomServiceRequests) {
		this.roomServiceRequests = roomServiceRequests;
	}

	public InputStream getInputStream() {
		return inputStream;
	}

	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}

	public List<BreakfastServiceRequests> getBreakfastServiceRequests() {
		return breakfastServiceRequests;
	}

	public void setBreakfastServiceRequests(List<BreakfastServiceRequests> breakfastServiceRequests) {
		this.breakfastServiceRequests = breakfastServiceRequests;
	}

	public BreakfastServiceRequests getBreakfastServiceRequest() {
		return breakfastServiceRequest;
	}

	public void setBreakfastServiceRequest(BreakfastServiceRequests breakfastServiceRequest) {
		this.breakfastServiceRequest = breakfastServiceRequest;
	}

}
