package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryWifi;

public class HotelDirectoryWifiDAO extends BaseDAO{
	public List<HotelDirectoryWifi> list(){
		List<HotelDirectoryWifi> hotelDirectoryWifi = new ArrayList<HotelDirectoryWifi>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryWifi = session.selectList("SqlMapHotelDirectoryWifi.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryWifi;
	}
	
	public HotelDirectoryWifi get(HotelDirectoryWifi hotelDirectoryWifi){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryWifi = session.selectOne("SqlMapHotelDirectoryWifi.get",hotelDirectoryWifi);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryWifi;
	}
	
	public HotelDirectoryWifi add(HotelDirectoryWifi hotelDirectoryWifi){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryWifi.add",hotelDirectoryWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryWifi;
	}
	
	public void update(HotelDirectoryWifi hotelDirectoryWifi){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryWifi.update",hotelDirectoryWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryWifi hotelDirectoryWifi){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryWifi.delete",hotelDirectoryWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
