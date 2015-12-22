package es.ubiqua.nhservices.backend.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import es.ubiqua.nhservices.manger.WakeUpAlarmManager;
import es.ubiqua.nhservices.model.WakeUpAlarm;
import es.ubiqua.nhservices.utils.Utils;

public class AlarmsAction extends ActionSupport {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private WakeUpAlarm wakeUpAlarm;
	private List<WakeUpAlarm> wakeUpAlarms;
	private int id;
	private String status;
	
	public String wakeUpList(){
		
		wakeUpAlarms = new WakeUpAlarmManager().listToday();
		
		return SUCCESS;
	}
	
	public String wakeUpActivate(){
		
		System.out.println("LEO MESSI : "+id);
		
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

}
