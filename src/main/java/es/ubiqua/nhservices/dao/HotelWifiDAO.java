package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelWifi;

public class HotelWifiDAO extends BaseDAO{
	public List<HotelWifi> list(){
		List<HotelWifi> hotelWifi = new ArrayList<HotelWifi>();
		SqlSession session = sql.openSession();
		try{
			hotelWifi = session.selectList("SqlMapHotelWifi.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelWifi;
	}
	
	public HotelWifi get(HotelWifi hotelWifi){
		SqlSession session = sql.openSession();
		try{
			hotelWifi = session.selectOne("SqlMapHotelWifi.get",hotelWifi);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelWifi;
	}
	
	public HotelWifi add(HotelWifi hotelWifi){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelWifi.add",hotelWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelWifi;
	}
	
	public void update(HotelWifi hotelWifi){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelWifi.update",hotelWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelWifi hotelWifi){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelWifi.delete",hotelWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
