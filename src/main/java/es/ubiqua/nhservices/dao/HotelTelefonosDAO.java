package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelTelefonos;

public class HotelTelefonosDAO extends BaseDAO{
	public List<HotelTelefonos> list(){
		List<HotelTelefonos> hotelTelefonos = new ArrayList<HotelTelefonos>();
		SqlSession session = sql.openSession();
		try{
			hotelTelefonos = session.selectList("SqlMapHotelTelefonos.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(/*e.getMessage()*/e);
		}finally{
			session.close();
		}
		return hotelTelefonos;
	}
	
	public HotelTelefonos get(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			hotelTelefonos = session.selectOne("SqlMapHotelTelefonos.get",hotelTelefonos);
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelTelefonos;
	}
	
	public HotelTelefonos add(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			session.insert("SqlMapHotelTelefonos.add",hotelTelefonos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
		return hotelTelefonos;
	}
	
	public void update(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			session.update("SqlMapHotelTelefonos.update",hotelTelefonos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
	
	public void del(HotelTelefonos hotelTelefonos){
		SqlSession session = sql.openSession();
		try{
			session.delete("SqlMapHotelTelefonos.delete",hotelTelefonos);
			session.commit();
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e.getMessage());
		}finally{
			session.close();
		}
	}
}
