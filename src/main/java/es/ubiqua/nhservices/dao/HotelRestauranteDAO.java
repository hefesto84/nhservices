package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelRestaurante;

public class HotelRestauranteDAO extends BaseDAO{
	public List<HotelRestaurante> list(){
		List<HotelRestaurante> hotelRestaurante = new ArrayList<HotelRestaurante>();
		SqlSession session = sql.openSession();
		try{
			hotelRestaurante = session.selectList("SqlMapCustomer.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelRestaurante;
	}
	
	public HotelRestaurante get(HotelRestaurante hotelRestaurante){
		SqlSession session = sql.openSession();
		try{
			hotelRestaurante = session.selectOne("SqlMapHotel.get",hotelRestaurante);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelRestaurante;
	}
	
	public HotelRestaurante add(HotelRestaurante hotelRestaurante){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotelRestaurante);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelRestaurante;
	}
}
