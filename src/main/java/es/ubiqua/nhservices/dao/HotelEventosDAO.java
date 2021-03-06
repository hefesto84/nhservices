package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelEventos;

public class HotelEventosDAO extends BaseDAO {
	public List<HotelEventos> list(){
		List<HotelEventos> hotelEventos = new ArrayList<HotelEventos>();
		SqlSession session = sql.openSession();
		try{
			hotelEventos = session.selectList("SqlMapHotelEventos.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelEventos;
	}
	
	public HotelEventos get(HotelEventos hotelEventos){
		SqlSession session = sql.openSession();
		try{
			hotelEventos = session.selectOne("SqlMapHotelEventos.get",hotelEventos);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelEventos;
	}
	
	public HotelEventos add(HotelEventos hotelEventos){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelEventos.add",hotelEventos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelEventos;
	}
	
	public void update(HotelEventos hotelEventos){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelEventos.update",hotelEventos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelEventos hotelEventos){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelEventos.delete",hotelEventos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
