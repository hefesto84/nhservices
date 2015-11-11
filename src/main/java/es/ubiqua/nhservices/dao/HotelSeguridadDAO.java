package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelSeguridad;

public class HotelSeguridadDAO extends BaseDAO{
	public List<HotelSeguridad> list(){
		List<HotelSeguridad> hotelSeguridad = new ArrayList<HotelSeguridad>();
		SqlSession session = sql.openSession();
		try{
			hotelSeguridad = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelSeguridad;
	}
	
	public HotelSeguridad get(HotelSeguridad hotelSeguridad){
		SqlSession session = sql.openSession();
		try{
			hotelSeguridad = session.selectOne("SqlMapHotel.get",hotelSeguridad);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSeguridad;
	}
	
	public HotelSeguridad add(HotelSeguridad hotelSeguridad){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelSeguridad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSeguridad;
	}
}
