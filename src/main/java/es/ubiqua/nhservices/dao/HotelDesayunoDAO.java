package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelDesayuno;

public class HotelDesayunoDAO extends BaseDAO{
	public List<HotelDesayuno> list(){
		List<HotelDesayuno> hotelDesayuno = new ArrayList<HotelDesayuno>();
		SqlSession session = sql.openSession();
		try{
			hotelDesayuno = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDesayuno;
	}
	
	public HotelDesayuno get(HotelDesayuno hotelDesayuno){
		SqlSession session = sql.openSession();
		try{
			hotelDesayuno = session.selectOne("SqlMapHotel.get",hotelDesayuno);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDesayuno;
	}
	
	public HotelDesayuno add(HotelDesayuno hotelDesayuno){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelDesayuno);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDesayuno;
	}
}
