package es.ubiqua.nhservices.manger;


import es.ubiqua.nhservices.dao.RoomExtensionDAO;
import es.ubiqua.nhservices.model.RoomExtension;

public class RoomExtensionManager {
	
	private RoomExtensionDAO roomExtensionDao = new RoomExtensionDAO();
	
	public RoomExtensionManager(){
		
	}
	
	/*public List<WakeUpAlarm> listToday(){
		return wakeUpAlarmDao.listToday();
	}*/

	public RoomExtension get(RoomExtension roomExtension){
		return roomExtensionDao.get(roomExtension);
	}

	/*public WakeUpAlarm getByRandomId(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.getByRandomId(wakeUpAlarm);
	}
	
	public WakeUpAlarm add(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.add(wakeUpAlarm);
	}
	
	public WakeUpAlarm confirmAlarm(WakeUpAlarm wakeUpAlarm){
		return wakeUpAlarmDao.confirmAlarm(wakeUpAlarm);
	}*/

}
