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
			hotelServicios = session.selectList("SqlMapCustomer.list");
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
			hotelServicios = session.selectOne("SqlMapHotel.get",hotelServicios);
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
			session.insert("SqlMapHotel.add",hotelServicios);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelServicios;
	}
}
