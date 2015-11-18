package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelSostenibilidad;

public class HotelSostenibilidadDAO extends BaseDAO{
	
	public List<HotelSostenibilidad> list(Hotel h, String lang){
		List<HotelSostenibilidad> hotelSostenibilidad = new ArrayList<HotelSostenibilidad>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelSostenibilidad = session.selectList("SqlMapHotelSostenibilidad.list",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelSostenibilidad;
	}
	
	public HotelSostenibilidad get(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			hotelSostenibilidad = session.selectOne("SqlMapHotelSostenibilidad.get",hotelSostenibilidad);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSostenibilidad;
	}
	
	public HotelSostenibilidad add(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelSostenibilidad.add",hotelSostenibilidad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSostenibilidad;
	}
	
	public void update(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelSostenibilidad.update",hotelSostenibilidad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelSostenibilidad.delete",hotelSostenibilidad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
