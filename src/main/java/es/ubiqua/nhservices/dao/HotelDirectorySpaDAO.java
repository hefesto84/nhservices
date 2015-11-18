package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectorySpa;

public class HotelDirectorySpaDAO extends BaseDAO{
	
	public List<HotelDirectorySpa> list(Hotel h, String lang){
		List<HotelDirectorySpa> hotelDirectorySpa = new ArrayList<HotelDirectorySpa>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelDirectorySpa = session.selectList("SqlMapHotelDirectorySpa.list",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectorySpa;
	}
	
	public HotelDirectorySpa get(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			hotelDirectorySpa = session.selectOne("SqlMapHotelDirectorySpa.get",hotelDirectorySpa);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectorySpa;
	}
	
	public HotelDirectorySpa add(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectorySpa.add",hotelDirectorySpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectorySpa;
	}
	
	public void update(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectorySpa.update",hotelDirectorySpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectorySpa.delete",hotelDirectorySpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
