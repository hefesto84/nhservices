package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.RoomServiceAnswers;
import es.ubiqua.nhservices.model.RoomServiceQuestions;

public class RoomServiceAnswersDAO extends BaseDAO{
	
	public List<RoomServiceAnswers> listByPlato(RoomServiceQuestions roomServiceQuestions, String lang){
		List<RoomServiceAnswers> roomServiceAnswers = new ArrayList<RoomServiceAnswers>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("question", roomServiceQuestions);
			map.put("lang", lang);
			roomServiceAnswers = session.selectList("SqlMapRoomServiceAnswers.listByPlato",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return roomServiceAnswers;
	}
	
	public RoomServiceAnswers getAnswerByIdEs(int id){
		RoomServiceAnswers answers = new RoomServiceAnswers();
		SqlSession session = sql.openSession();
		try{
			answers = session.selectOne("SqlMapRoomServiceAnswers.getAnswerByIdEs",id);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return answers;
	}
	
	/*public List<WakeUpAlarm> listToday(){
		List<WakeUpAlarm> wakeUpAlarm = new ArrayList<WakeUpAlarm>();
		SqlSession session = sql.openSession();
		try{
			wakeUpAlarm = session.selectList("SqlMapWakeUpAlarm.listToday");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}
	
	public RoomServiceRequests get(RoomServiceRequests roomServiceRequests){
		SqlSession session = sql.openSession();
		try{
			roomServiceRequests = session.selectOne("SqlMapRoomServiceRequests.get",roomServiceRequests);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return roomServiceRequests;
	}
	
	public RoomServiceRequests getByRandomId(RoomServiceRequests roomServiceRequests){
		SqlSession session = sql.openSession();
		try{
			roomServiceRequests = session.selectOne("SqlMapRoomServiceRequests.getByRandomId",roomServiceRequests);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return roomServiceRequests;
	}
	
	public RoomServiceRequests add(RoomServiceRequests roomServiceRequests){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapRoomServiceRequests.add",roomServiceRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return roomServiceRequests;
	}
	
	public RoomServiceRequests confirmRequest(RoomServiceRequests roomServiceRequests){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapRoomServiceRequests.confirmRequest",roomServiceRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return roomServiceRequests;
	}*/

}
