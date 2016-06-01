package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelLinks;

public class HotelLinksDAO extends BaseDAO{
	public List<HotelLinks> list(){
		List<HotelLinks> hotel = new ArrayList<HotelLinks>();
		SqlSession session = sql.openSession();
		try{
			hotel = session.selectList("SqlMapHotelLinks.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return hotel;
	}

}
