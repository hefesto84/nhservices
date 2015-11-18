package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelTelefonos;

public class HotelTelefonosDAO extends BaseDAO{
	
	public List<HotelTelefonos> list(Hotel h, String lang){
		List<HotelTelefonos> hotelTelefonos = new ArrayList<HotelTelefonos>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			hotelTelefonos = session.selectList("SqlMapHotelTelefonos.list",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelTelefonos;
	}
	
	public HotelTelefonos get(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			hotelTelefonos = session.selectOne("SqlMapHotelTelefonos.get",hotelTelefonos);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelTelefonos;
	}
	
	public HotelTelefonos add(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelTelefonos.add",hotelTelefonos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelTelefonos;
	}
	
	public void update(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelTelefonos.update",hotelTelefonos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelTelefonos.delete",hotelTelefonos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
