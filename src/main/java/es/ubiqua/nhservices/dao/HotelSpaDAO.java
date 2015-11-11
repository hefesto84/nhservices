package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelSpa;

public class HotelSpaDAO extends BaseDAO{
	public List<HotelSpa> list(){
		List<HotelSpa> hotelSpa = new ArrayList<HotelSpa>();
		SqlSession session = sql.openSession();
		try{
			hotelSpa = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelSpa;
	}
	
	public HotelSpa get(HotelSpa hotelSpa){
		SqlSession session = sql.openSession();
		try{
			hotelSpa = session.selectOne("SqlMapHotel.get",hotelSpa);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSpa;
	}
	
	public HotelSpa add(HotelSpa hotelSpa){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelSpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelSpa;
	}
}
