package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelServicios;

public class HotelServiciosDAO extends BaseDAO{
	public List<HotelServicios> list(){
		List<HotelServicios> hotelServicios = new ArrayList<HotelServicios>();
		SqlSession session = sql.openSession();
		try{
			hotelServicios = session.selectList("SqlMapHotelServicios.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelServicios;
	}
	
	public HotelServicios get(HotelServicios hotelServicios){
		SqlSession session = sql.openSession();
		try{
			hotelServicios = session.selectOne("SqlMapHotelServicios.get",hotelServicios);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelServicios;
	}
	
	public HotelServicios add(HotelServicios hotelServicios){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelServicios.add",hotelServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelServicios;
	}
	
	public void update(HotelServicios hotelServicios){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelServicios.update",hotelServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelServicios hotelServicios){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelServicios.delete",hotelServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
