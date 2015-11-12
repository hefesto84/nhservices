package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryEventos;

public class HotelDirectoryEventosDAO extends BaseDAO {
	public List<HotelDirectoryEventos> list(){
		List<HotelDirectoryEventos> hotelDirectoryEventos = new ArrayList<HotelDirectoryEventos>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryEventos = session.selectList("SqlMapHotelDirectoryEventos.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryEventos;
	}
	
	public HotelDirectoryEventos get(HotelDirectoryEventos hotelDirectoryEventos){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryEventos = session.selectOne("SqlMapHotelDirectoryEventos.get",hotelDirectoryEventos);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryEventos;
	}
	
	public HotelDirectoryEventos add(HotelDirectoryEventos hotelDirectoryEventos){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryEventos.add",hotelDirectoryEventos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryEventos;
	}
	
	public void update(HotelDirectoryEventos hotelDirectoryEventos){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryEventos.update",hotelDirectoryEventos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryEventos hotelDirectoryEventos){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryEventos.delete",hotelDirectoryEventos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
