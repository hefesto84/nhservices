package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelRequestsDAO;
import es.ubiqua.nhservices.model.HotelRequests;

public class HotelRequestsManager {
	
	private HotelRequestsDAO hotelRequestsDao = new HotelRequestsDAO();
	
	public HotelRequestsManager(){
		
	}
	
	public List<HotelRequests> list(){
		return hotelRequestsDao.list();
	}

	public HotelRequests get(HotelRequests hotelRequests){
		return hotelRequestsDao.get(hotelRequests);
	}
	
	public HotelRequests add(HotelRequests hotelRequests){
		return hotelRequestsDao.add(hotelRequests);
	}
	
	public void update(HotelRequests hotelRequests){
		hotelRequestsDao.update(hotelRequests);
	}
	
	public void del(HotelRequests hotelRequests){
		hotelRequestsDao.del(hotelRequests);
	}
}
