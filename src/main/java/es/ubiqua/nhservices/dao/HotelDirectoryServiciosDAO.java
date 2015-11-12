package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryServicios;

public class HotelDirectoryServiciosDAO extends BaseDAO{
	public List<HotelDirectoryServicios> list(){
		List<HotelDirectoryServicios> hotelDirectoryServicios = new ArrayList<HotelDirectoryServicios>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryServicios = session.selectList("SqlMapHotelDirectoryServicios.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
	
	public HotelDirectoryServicios get(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryServicios = session.selectOne("SqlMapHotelDirectoryServicios.get",hotelDirectoryServicios);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
	
	public HotelDirectoryServicios add(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryServicios.add",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
	
	public void update(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryServicios.update",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryServicios hotelDirectoryServicios){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryServicios.delete",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
