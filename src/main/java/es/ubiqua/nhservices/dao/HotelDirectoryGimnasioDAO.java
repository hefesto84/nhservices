package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelDirectoryGimnasio;

public class HotelDirectoryGimnasioDAO extends BaseDAO{
	public List<HotelDirectoryGimnasio> list(Hotel h, String lang){
		List<HotelDirectoryGimnasio> hotelDirectoryGimnasio = new ArrayList<HotelDirectoryGimnasio>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelDirectoryGimnasio = session.selectList("SqlMapHotelDirectoryGimnasio.list",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryGimnasio;
	}
	
	public HotelDirectoryGimnasio get(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryGimnasio = session.selectOne("SqlMapHotelDirectoryGimnasio.get",hotelDirectoryGimnasio);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryGimnasio;
	}
	
	public HotelDirectoryGimnasio add(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryGimnasio.add",hotelDirectoryGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryGimnasio;
	}
	
	public void update(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryGimnasio.update",hotelDirectoryGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryGimnasio.delete",hotelDirectoryGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
