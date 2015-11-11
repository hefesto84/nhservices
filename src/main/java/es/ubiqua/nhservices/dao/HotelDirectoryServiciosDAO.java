package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelDirectoryServicios;

public class HotelDirectoryServiciosDAO extends BaseDAO{
	public List<HotelDirectoryServicios> list(){
		List<HotelDirectoryServicios> hotelDirectoryServicios = new ArrayList<HotelDirectoryServicios>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryServicios = session.selectList("SqlMapCustomer.list");
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
			hotelDirectoryServicios = session.selectOne("SqlMapHotel.get",hotelDirectoryServicios);
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
			session.insert("SqlMapHotel.add",hotelDirectoryServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryServicios;
	}
}
