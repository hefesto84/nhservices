package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.RoomServiceIngredientes;

public class RoomServiceIngredientesDAO extends BaseDAO{
	
	public List<RoomServiceIngredientes> list(Hotel h, String lang){
		List<RoomServiceIngredientes> roomServiceIngredientes = new ArrayList<RoomServiceIngredientes>();
		SqlSession session = sql.openSession();
		try{
			Map<String,Object> map = new HashMap<String,Object>();
			map.put("hotel", h);
			map.put("lang", lang);
			roomServiceIngredientes = session.selectList("SqlMapRoomServiceIngredientes.list",map);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return roomServiceIngredientes;
	}
	
	/*public HotelDirectoryRestaurantes get(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryRestaurantes = session.selectOne("SqlMapHotelDirectoryRestaurantes.get",hotelDirectoryRestaurantes);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryRestaurantes;
	}
	
	public HotelDirectoryRestaurantes add(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryRestaurantes.add",hotelDirectoryRestaurantes);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryRestaurantes;
	}
	
	public void update(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryRestaurantes.update",hotelDirectoryRestaurantes);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryRestaurantes.delete",hotelDirectoryRestaurantes);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}*/
}
