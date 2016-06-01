package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServiceQuestionsDAO;
import es.ubiqua.nhservices.model.RoomServiceQuestions;

public class RoomServiceQuestionsManager {
	
	private RoomServiceQuestionsDAO roomServiceQuestionsDao = new RoomServiceQuestionsDAO();
	
	public RoomServiceQuestionsManager(){
		
	}
	
	public List<RoomServiceQuestions> list(){
		return roomServiceQuestionsDao.list();
	}
	
	public List<RoomServiceQuestions> listByProduct(int id, String lang){
		return roomServiceQuestionsDao.listByProduct(id, lang);
	}
	
	public RoomServiceQuestions getByIdEs(int id_product, int id_question){
		return roomServiceQuestionsDao.getByIdEs(id_product, id_question);
	}
	
	/*public List<WakeUpAlarm> listToday(){
		return wakeUpAlarmDao.listToday();
	}

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
	}*/

}
