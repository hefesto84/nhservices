package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServiceRequestsDAO;
import es.ubiqua.nhservices.model.RoomServiceRequests;

public class RoomServiceRequestsManager {
	
	private RoomServiceRequestsDAO roomServiceRequestsDao = new RoomServiceRequestsDAO();
	
	public RoomServiceRequestsManager(){
		
	}
	
	public List<RoomServiceRequests> list(){
		return roomServiceRequestsDao.list();
	}
	
	/*public List<WakeUpAlarm> listToday(){
		return wakeUpAlarmDao.listToday();
	}*/

	public RoomServiceRequests get(RoomServiceRequests roomServiceRequests){
		return roomServiceRequestsDao.get(roomServiceRequests);
	}

	public RoomServiceRequests getByRandomId(RoomServiceRequests roomServiceRequests){
		return roomServiceRequestsDao.getByRandomId(roomServiceRequests);
	}
	
	public RoomServiceRequests add(RoomServiceRequests roomServiceRequests){
		return roomServiceRequestsDao.add(roomServiceRequests);
	}
	
	public RoomServiceRequests confirmRequest(RoomServiceRequests roomServiceRequests){
		return roomServiceRequestsDao.confirmRequest(roomServiceRequests);
	}

}
