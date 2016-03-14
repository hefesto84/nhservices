package es.ubiqua.nhservices.manger;

import es.ubiqua.nhservices.dao.BreakfastRequestsDAO;
import es.ubiqua.nhservices.model.BreakfastRequests;

public class BreakfastRequestsManager {
	
	private BreakfastRequestsDAO breakfastRequestsDao = new BreakfastRequestsDAO();
	
	public BreakfastRequestsManager(){
		
	}
	
	/*public List<BreakfastServiceRequests> list(){
		return breakfastServiceRequestsDao.list();
	}*/
	
	/*public List<WakeUpAlarm> listToday(){
		return wakeUpAlarmDao.listToday();
	}*/

	/*public BreakfastServiceRequests get(BreakfastServiceRequests breakfastServiceRequests){
		return breakfastServiceRequestsDao.get(breakfastServiceRequests);
	}*/
	
	public BreakfastRequests get(){
		return breakfastRequestsDao.get();
	}
	
	public BreakfastRequests add(BreakfastRequests breakfastRequests){
		return breakfastRequestsDao.add(breakfastRequests);
	}
	
	public BreakfastRequests confirmRequest(BreakfastRequests breakfastRequests){
		return breakfastRequestsDao.confirmRequest(breakfastRequests);
	}

}
