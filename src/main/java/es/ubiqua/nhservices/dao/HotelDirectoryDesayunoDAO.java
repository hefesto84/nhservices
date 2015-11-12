package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryDesayuno;

public class HotelDirectoryDesayunoDAO extends BaseDAO {
	
	public List<HotelDirectoryDesayuno> list(){
		List<HotelDirectoryDesayuno> hotelDirectoryDesayuno = new ArrayList<HotelDirectoryDesayuno>();
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryDesayuno = session.selectList("SqlMapHotelDirectoryDesayuno.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelDirectoryDesayuno;
	}
	
	public HotelDirectoryDesayuno get(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		SqlSession session = sql.openSession();
		try{
			hotelDirectoryDesayuno = session.selectOne("SqlMapHotelDirectoryDesayuno.get",hotelDirectoryDesayuno);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryDesayuno;
	}
	
	public HotelDirectoryDesayuno add(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelDirectoryDesayuno.add",hotelDirectoryDesayuno);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelDirectoryDesayuno;
	}
	
	public void update(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelDirectoryDesayuno.update",hotelDirectoryDesayuno);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelDirectoryDesayuno.delete",hotelDirectoryDesayuno);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
