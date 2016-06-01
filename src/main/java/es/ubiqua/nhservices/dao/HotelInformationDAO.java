package es.ubiqua.nhservices.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;

import es.ubiqua.nhservices.model.HotelInformation;

public class HotelInformationDAO extends BaseDAO{
	public List<HotelInformation> list(){
		List<HotelInformation> hotel = new ArrayList<HotelInformation>();
		SqlSession session = sql.openSession();
		try{
			hotel = session.selectList("SqlMapHotelInformation.list");
		}catch(Exception e){
			Logger.getLogger(this.getClass()).error(e);
		}finally{
			session.close();
		}
		return hotel;
	}

}
