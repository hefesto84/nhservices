package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelDirectoryServicios;

public class HotelDirectoryServiciosDAO extends BaseDAO{
	
	public List<HotelDirectoryServicios> list(Hotel h, String lang){
		
		List<HotelDirectoryServicios> hotelDirectoryServicios = new ArrayList<HotelDirectoryServicios>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelDirectoryServicios = session.selectList("SqlMapHotelDirectoryServicios.list",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
	
	public HotelDirectoryServicios get(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryServicios = session.selectOne("SqlMapHotelDirectoryServicios.get",hotelDirectoryServicios);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
	
	public HotelDirectoryServicios add(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryServicios.add",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
	
	public void update(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryServicios.update",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryServicios.delete",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
