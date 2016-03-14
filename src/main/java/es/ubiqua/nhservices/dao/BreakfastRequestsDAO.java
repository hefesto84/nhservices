package es.ubiqua.nhservices.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.BreakfastRequests;

public class BreakfastRequestsDAO extends BaseDAO{
	
	/*public List<BreakfastServiceRequests> list(){
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
	}*/
	
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
	
	/*public BreakfastServiceRequests get(BreakfastServiceRequests breakfastServiceRequests){
		SqlSession session = sql.openSession();
		try{
			breakfastServiceRequests = session.selectOne("SqlMapBreakfastServiceRequests.get",breakfastServiceRequests);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return breakfastServiceRequests;
	}*/
	
	public BreakfastRequests get(){
		BreakfastRequests breakfastRequests = new BreakfastRequests();
		SqlSession session = sql.openSession();
		try{
			breakfastRequests = session.selectOne("SqlMapBreakfastRequests.get");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return breakfastRequests;
	}
	
	
	public BreakfastRequests add(BreakfastRequests breakfastRequests){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapBreakfastRequests.add",breakfastRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return breakfastRequests;
	}
	
	public BreakfastRequests confirmRequest(BreakfastRequests breakfastRequests){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapBreakfastRequests.confirmRequest",breakfastRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return breakfastRequests;
	}

}
