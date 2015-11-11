package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelDirectoryPicina;

public class HotelDirectoryPicinaDAO extends BaseDAO{
	public List<HotelDirectoryPicina> list(){
		List<HotelDirectoryPicina> hotelDirectoryPicina = new ArrayList<HotelDirectoryPicina>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryPicina = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryPicina;
	}
	
	public HotelDirectoryPicina get(HotelDirectoryPicina hotelDirectoryPicina){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryPicina = session.selectOne("SqlMapHotel.get",hotelDirectoryPicina);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryPicina;
	}
	
	public HotelDirectoryPicina add(HotelDirectoryPicina hotelDirectoryPicina){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelDirectoryPicina);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryPicina;
	}
}
