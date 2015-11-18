package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;

public class HotelCanalesDAO extends BaseDAO{
	
	public List<HotelCanales> list(Hotel h, String lang){
		List<HotelCanales> hotelCanales = new ArrayList<HotelCanales>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelCanales = session.selectList("SqlMapHotelCanales.list", map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelCanales;
	}
	
	public HotelCanales get(HotelCanales hotelCanales){
		SqlSession session = sql.openSession();
		try{
			hotelCanales = session.selectOne("SqlMapHotelCanales.get",hotelCanales);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelCanales;
	}
	
	public HotelCanales add(HotelCanales hotelCanales){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelCanales.add",hotelCanales);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelCanales;
	}
	
	public void update(HotelCanales hotelCanales){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelCanales.update",hotelCanales);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelCanales hotelCanales){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelCanales.delete",hotelCanales);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
}
