package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelDirectoryGimnasio;

public class HotelDirectoryGimnasioDAO extends BaseDAO{
	public List<HotelDirectoryGimnasio> list(){
		List<HotelDirectoryGimnasio> hotelDirectoryGimnasio = new ArrayList<HotelDirectoryGimnasio>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryGimnasio = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryGimnasio;
	}
	
	public HotelDirectoryGimnasio get(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryGimnasio = session.selectOne("SqlMapHotel.get",hotelDirectoryGimnasio);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryGimnasio;
	}
	
	public HotelDirectoryGimnasio add(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelDirectoryGimnasio);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryGimnasio;
	}
}
