package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectorySpa;

public class HotelDirectorySpaDAO extends BaseDAO{
	public List<HotelDirectorySpa> list(){
		List<HotelDirectorySpa> hotelDirectorySpa = new ArrayList<HotelDirectorySpa>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectorySpa = session.selectList("SqlMapHotelDirectorySpa.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectorySpa;
	}
	
	public HotelDirectorySpa get(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			hotelDirectorySpa = session.selectOne("SqlMapHotelDirectorySpa.get",hotelDirectorySpa);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectorySpa;
	}
	
	public HotelDirectorySpa add(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectorySpa.add",hotelDirectorySpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectorySpa;
	}
	
	public void update(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectorySpa.update",hotelDirectorySpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectorySpa hotelDirectorySpa){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectorySpa.delete",hotelDirectorySpa);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
