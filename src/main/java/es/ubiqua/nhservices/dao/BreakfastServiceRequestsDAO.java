package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.BreakfastServiceRequests;

public class BreakfastServiceRequestsDAO extends BaseDAO{
	
	public List<BreakfastServiceRequests> list(){
		List<BreakfastServiceRequests> breakfastServiceRequests = new ArrayList<BreakfastServiceRequests>();
		SqlSession session = sql.openSession();
		try{
			breakfastServiceRequests = session.selectList("SqlMapBreakfastServiceRequests.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return breakfastServiceRequests;
	}
	
	public List<BreakfastServiceRequests> listToday(){
		List<BreakfastServiceRequests> breakfastServiceRequests = new ArrayList<BreakfastServiceRequests>();
		SqlSession session = sql.openSession();
		try{
			breakfastServiceRequests = session.selectList("SqlMapBreakfastServiceRequests.listToday");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return breakfastServiceRequests;
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
	
	public BreakfastServiceRequests get(BreakfastServiceRequests breakfastServiceRequests){
		SqlSession session = sql.openSession();
		try{
			breakfastServiceRequests = session.selectOne("SqlMapBreakfastServiceRequests.get",breakfastServiceRequests);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return breakfastServiceRequests;
	}
	
	
	public BreakfastServiceRequests add(BreakfastServiceRequests breakfastServiceRequests){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapBreakfastServiceRequests.add",breakfastServiceRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return breakfastServiceRequests;
	}

}
