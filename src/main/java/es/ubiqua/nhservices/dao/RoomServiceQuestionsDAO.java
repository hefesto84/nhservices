package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.RoomServiceQuestions;

public class RoomServiceQuestionsDAO extends BaseDAO{
	
	public List<RoomServiceQuestions> list(){
		List<RoomServiceQuestions> roomServiceQuestions = new ArrayList<RoomServiceQuestions>();
		SqlSession session = sql.openSession();
		try{
			roomServiceQuestions = session.selectList("SqlMapRoomServiceQuestions.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return roomServiceQuestions;
	}
	
	public List<RoomServiceQuestions> listByProduct(int id, String lang){
		List<RoomServiceQuestions> roomServiceQuestions = new ArrayList<RoomServiceQuestions>();
		SqlSession session = sql.openSession();
		try{
			Map<String,String> map = new HashMap<String,String>();
			map.put("id", String.valueOf(id));
			map.put("lang", lang);
			roomServiceQuestions = session.selectList("SqlMapRoomServiceQuestions.listByProduct",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return roomServiceQuestions;
	}
	
	public RoomServiceQuestions getByIdEs(int id_product, int id_question){
		RoomServiceQuestions roomServiceQuestion = new RoomServiceQuestions();
		SqlSession session = sql.openSession();
		try{
			Map<String,String> map = new HashMap<String,String>();
			map.put("id_product", String.valueOf(id_product));
			map.put("id_question", String.valueOf(id_question));
			roomServiceQuestion = session.selectOne("SqlMapRoomServiceQuestions.getByIdEs",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return roomServiceQuestion;
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
