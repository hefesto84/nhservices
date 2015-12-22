package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelGimnasio;

public class HotelGimnasioDAO extends BaseDAO{
	public List<HotelGimnasio> list(){
		List<HotelGimnasio> hotelGimnasio = new ArrayList<HotelGimnasio>();
		SqlSession session = sql.openSession();
		try{
			hotelGimnasio = session.selectList("SqlMapHotelGimnasio.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelGimnasio;
	}
	
	public HotelGimnasio get(HotelGimnasio hotelGimnasio){
		SqlSession session = sql.openSession();
		try{
			hotelGimnasio = session.selectOne("SqlMapHotelGimnasio.get",hotelGimnasio);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelGimnasio;
	}
	
	public HotelGimnasio add(HotelGimnasio hotelGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelGimnasio.add",hotelGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelGimnasio;
	}
	
	public void update(HotelGimnasio hotelGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelGimnasio.update",hotelGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelGimnasio hotelGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelGimnasio.delete",hotelGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
