package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelWifi;

public class HotelWifiDAO extends BaseDAO{
	public List<HotelWifi> list(){
		List<HotelWifi> hotelWifi = new ArrayList<HotelWifi>();
		SqlSession session = sql.openSession();
		try{
			hotelWifi = session.selectList("SqlMapCustomer.list");
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
			hotelWifi = session.selectOne("SqlMapHotel.get",hotelWifi);
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
			session.insert("SqlMapHotel.add",hotelWifi);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelWifi;
	}
}
