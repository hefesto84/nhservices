package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelSeguridad;

public class HotelSeguridadDAO extends BaseDAO{
	
	public List<HotelSeguridad> list(Hotel h, String lang){
		List<HotelSeguridad> hotelSeguridad = new ArrayList<HotelSeguridad>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelSeguridad = session.selectList("SqlMapHotelSeguridad.list",map);
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
			hotelSeguridad = session.selectOne("SqlMapHotelSeguridad.get",hotelSeguridad);
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
			session.insert("SqlMapHotelSeguridad.add",hotelSeguridad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSeguridad;
	}
	
	public void update(HotelSeguridad hotelSeguridad){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelSeguridad.update",hotelSeguridad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelSeguridad hotelSeguridad){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelSeguridad.delete",hotelSeguridad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
