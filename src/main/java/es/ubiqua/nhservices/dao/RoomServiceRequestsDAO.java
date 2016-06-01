package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.RoomServiceRequests;

public class RoomServiceRequestsDAO extends BaseDAO{
	
	public List<RoomServiceRequests> list(){
		List<RoomServiceRequests> roomServiceRequests = new ArrayList<RoomServiceRequests>();
		SqlSession session = sql.openSession();
		try{
			roomServiceRequests = session.selectList("SqlMapRoomServiceRequests.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return roomServiceRequests;
	}
	
	public List<RoomServiceRequests> listFutureRoomServices(){
		List<RoomServiceRequests> roomServiceRequests = new ArrayList<RoomServiceRequests>();
		SqlSession session = sql.openSession();
		try{
			roomServiceRequests = session.selectList("SqlMapRoomServiceRequests.listFutureRoomServices");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return roomServiceRequests;
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
	}*/
	
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
	}

}
