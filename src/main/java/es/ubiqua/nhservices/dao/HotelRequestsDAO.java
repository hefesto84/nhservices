package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelRequests;

public class HotelRequestsDAO extends BaseDAO{
	public List<HotelRequests> list(){
		List<HotelRequests> hotelRequests = new ArrayList<HotelRequests>();
		SqlSession session = sql.openSession();
		try{
			hotelRequests = session.selectList("SqlMapHotelRequests.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelRequests;
	}
	
	public HotelRequests get(HotelRequests hotelRequests){
		SqlSession session = sql.openSession();
		try{
			hotelRequests = session.selectOne("SqlMapHotelRequests.get",hotelRequests);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelRequests;
	}
	
	public HotelRequests add(HotelRequests hotelRequests){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelRequests.add",hotelRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelRequests;
	}
	
	public void update(HotelRequests hotelRequests){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelRequests.update",hotelRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelRequests hotelRequests){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelRequests.delete",hotelRequests);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
