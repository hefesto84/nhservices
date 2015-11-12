package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryRestaurantes;

public class HotelDirectoryRestauranteDAO extends BaseDAO{
	public List<HotelDirectoryRestaurantes> list(){
		List<HotelDirectoryRestaurantes> hotelDirectoryRestaurantes = new ArrayList<HotelDirectoryRestaurantes>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryRestaurantes = session.selectList("SqlMapHotelDirectoryRestaurantes.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryRestaurantes;
	}
	
	public HotelDirectoryRestaurantes get(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
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
	}
}
