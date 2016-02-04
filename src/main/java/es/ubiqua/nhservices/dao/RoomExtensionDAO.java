package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Language;
import es.ubiqua.nhservices.model.RoomExtension;
import es.ubiqua.nhservices.model.WakeUpAlarm;

public class RoomExtensionDAO extends BaseDAO{
	
	/*public List<WakeUpAlarm> listToday(){
		List<WakeUpAlarm> wakeUpAlarm = new ArrayList<WakeUpAlarm>();
		SqlSession session = sql.openSession();
		try{
			wakeUpAlarm = session.selectList("SqlMapWakeUpAlarm.listToday");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(*//*e.getMessage()*//*e);
		}finally{
			session.close();
		}
		return wakeUpAlarm;
	}*/
	
	public RoomExtension get(RoomExtension roomExtension){
		SqlSession session = sql.openSession();
		try{
			roomExtension = session.selectOne("SqlMapRoomExtension.get",roomExtension);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return roomExtension;
	}
	
	/*public WakeUpAlarm getByRandomId(WakeUpAlarm wakeUpAlarm){
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
	}*/

}
