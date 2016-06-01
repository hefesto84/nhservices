package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServiceAnswersDAO;
import es.ubiqua.nhservices.model.RoomServiceAnswers;
import es.ubiqua.nhservices.model.RoomServiceQuestions;

public class RoomServiceAnswersManager {
	
	private RoomServiceAnswersDAO roomServiceAnswersDao = new RoomServiceAnswersDAO();
	
	public RoomServiceAnswersManager(){
		
	}
	
	/*public List<RoomServiceQuestions> list(){
		return roomServiceQuestionsDao.list();
	}*/
	
	public List<RoomServiceAnswers> listByPlato(RoomServiceQuestions roomServiceQuestions, String lang){
		return roomServiceAnswersDao.listByPlato(roomServiceQuestions, lang);
	}
	
	public RoomServiceAnswers getAnswerByIdEs(int id){
		return roomServiceAnswersDao.getAnswerByIdEs(id);
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
