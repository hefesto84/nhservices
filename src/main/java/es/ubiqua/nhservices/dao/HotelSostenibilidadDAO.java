package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelSostenibilidad;

public class HotelSostenibilidadDAO extends BaseDAO{
	public List<HotelSostenibilidad> list(){
		List<HotelSostenibilidad> hotelSostenibilidad = new ArrayList<HotelSostenibilidad>();
		SqlSession session = sql.openSession();
		try{
			hotelSostenibilidad = session.selectList("SqlMapHotelSostenibilidad.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelSostenibilidad;
	}
	
	public HotelSostenibilidad get(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			hotelSostenibilidad = session.selectOne("SqlMapHotelSostenibilidad.get",hotelSostenibilidad);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSostenibilidad;
	}
	
	public HotelSostenibilidad add(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelSostenibilidad.add",hotelSostenibilidad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSostenibilidad;
	}
	
	public void update(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelSostenibilidad.update",hotelSostenibilidad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelSostenibilidad hotelSostenibilidad){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelSostenibilidad.delete",hotelSostenibilidad);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
