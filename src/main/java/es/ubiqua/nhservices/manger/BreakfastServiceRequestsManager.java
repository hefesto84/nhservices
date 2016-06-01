package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.BreakfastServiceRequestsDAO;
import es.ubiqua.nhservices.model.BreakfastServiceRequests;

public class BreakfastServiceRequestsManager {
	
	private BreakfastServiceRequestsDAO breakfastServiceRequestsDao = new BreakfastServiceRequestsDAO();
	
	public BreakfastServiceRequestsManager(){
		
	}
	
	public List<BreakfastServiceRequests> list(){
		return breakfastServiceRequestsDao.list();
	}
	
	public List<BreakfastServiceRequests> listFutureBreakfasts(){
		return breakfastServiceRequestsDao.listFutureBreakfasts();
	}
	
	public List<BreakfastServiceRequests> listToday(){
		return breakfastServiceRequestsDao.listToday();
	}
	
	/*public List<WakeUpAlarm> listToday(){
		return wakeUpAlarmDao.listToday();
	}*/

	public BreakfastServiceRequests get(BreakfastServiceRequests breakfastServiceRequests){
		return breakfastServiceRequestsDao.get(breakfastServiceRequests);
	}
	
	public BreakfastServiceRequests add(BreakfastServiceRequests breakfastServiceRequests){
		return breakfastServiceRequestsDao.add(breakfastServiceRequests);
	}

}
