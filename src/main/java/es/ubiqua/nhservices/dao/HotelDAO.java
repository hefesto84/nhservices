package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;

public class HotelDAO extends BaseDAO{
	public List<Hotel> list(){
		List<Hotel> hotel = new ArrayList<Hotel>();
		SqlSession session = sql.openSession();
		try{
			hotel = session.selectList("SqlMapHotel.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotel;
	}
	
	public Hotel get(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			hotel = session.selectOne("SqlMapHotel.get",hotel);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotel;
	}

	
	public Hotel add(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotel.add",hotel);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotel;
	}
	
	public void update(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotel.update",hotel);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(Hotel hotel){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotel.delete",hotel);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
