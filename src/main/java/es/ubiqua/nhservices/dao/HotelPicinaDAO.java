package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelPicina;

public class HotelPicinaDAO extends BaseDAO{
	public List<HotelPicina> list(){
		List<HotelPicina> hotelPicina = new ArrayList<HotelPicina>();
		SqlSession session = sql.openSession();
		try{
			hotelPicina = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelPicina;
	}
	
	public HotelPicina get(HotelPicina hotelPicina){
		SqlSession session = sql.openSession();
		try{
			hotelPicina = session.selectOne("SqlMapHotel.get",hotelPicina);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelPicina;
	}
	
	public HotelPicina add(HotelPicina hotelPicina){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelPicina);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelPicina;
	}
}
