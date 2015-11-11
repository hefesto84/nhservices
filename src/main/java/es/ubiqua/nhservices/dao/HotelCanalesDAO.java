package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;

public class HotelCanalesDAO extends BaseDAO{
	public List<HotelCanales> list(){
		List<HotelCanales> hotelCanales = new ArrayList<HotelCanales>();
		SqlSession session = sql.openSession();
		try{
			hotelCanales = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelCanales;
	}
	
	public HotelCanales get(HotelCanales hotelCanales){
		SqlSession session = sql.openSession();
		try{
			hotelCanales = session.selectOne("SqlMapHotel.get",hotelCanales);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelCanales;
	}
	
	public HotelCanales add(HotelCanales hotelCanales){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelCanales);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelCanales;
	}
}
