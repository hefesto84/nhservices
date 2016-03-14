package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.WakeUpAlarm;

public class WakeUpAlarmDAO extends BaseDAO{
	
	public List<WakeUpAlarm> listToday(){
		List<WakeUpAlarm> wakeUpAlarm = new ArrayList<WakeUpAlarm>();
		SqlSession session = sql.openSession();
		try{
			wakeUpAlarm = session.selectList("SqlMapWakeUpAlarm.listToday");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}
	
	public List<WakeUpAlarm> listByRoom(WakeUpAlarm wakeUpAlarm){
		List<WakeUpAlarm> wakeUpAlarms = new ArrayList<WakeUpAlarm>();
		SqlSession session = sql.openSession();
		try{
			wakeUpAlarms = session.selectList("SqlMapWakeUpAlarm.listByRoom",wakeUpAlarm);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return wakeUpAlarms;
	}
	
	public WakeUpAlarm get(WakeUpAlarm wakeUpAlarm){
		SqlSession session = sql.openSession();
		try{
			wakeUpAlarm = session.selectOne("SqlMapWakeUpAlarm.get",wakeUpAlarm);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}
	
	public WakeUpAlarm getByRandomId(WakeUpAlarm wakeUpAlarm){
		SqlSession session = sql.openSession();
		try{
			wakeUpAlarm = session.selectOne("SqlMapWakeUpAlarm.getByRandomId",wakeUpAlarm);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}
	
	public WakeUpAlarm add(WakeUpAlarm wakeUpAlarm){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapWakeUpAlarm.add",wakeUpAlarm);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}
	
	public WakeUpAlarm confirmAlarm(WakeUpAlarm wakeUpAlarm){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapWakeUpAlarm.confirmAlarm",wakeUpAlarm);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}
	
	public void del(WakeUpAlarm wakeUpAlarm){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapWakeUpAlarm.del",wakeUpAlarm);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}

}
