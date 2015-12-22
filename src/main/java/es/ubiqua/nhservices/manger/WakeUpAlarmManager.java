package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.WakeUpAlarmDAO;
import es.ubiqua.nhservices.model.Language;
import es.ubiqua.nhservices.model.WakeUpAlarm;

public class WakeUpAlarmManager {
	
	private WakeUpAlarmDAO wakeUpAlarmDao = new WakeUpAlarmDAO();
	
	public WakeUpAlarmManager(){
		
	}
	
	public List<WakeUpAlarm> listToday(){
		return wakeUpAlarmDao.listToday();
	}

	public WakeUpAlarm get(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.get(wakeUpAlarm);
	}

	public WakeUpAlarm getByRandomId(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.getByRandomId(wakeUpAlarm);
	}
	
	public WakeUpAlarm add(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.add(wakeUpAlarm);
	}
	
	public WakeUpAlarm confirmAlarm(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.confirmAlarm(wakeUpAlarm);
	}

}
