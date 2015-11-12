package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelSpaDAO;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelSpa;

public class HotelSpaManager {
	
	private HotelSpaDAO hotelSpaDao = new HotelSpaDAO();
	
	public HotelSpaManager(){
		
	}
	
	public List<HotelSpa> list(){
		return hotelSpaDao.list();
	}

	public HotelSpa get(HotelSpa hotelSpa){
		return hotelSpaDao.get(hotelSpa);
	}
	
	public HotelSpa add(HotelSpa hotelSpa){
		return hotelSpaDao.add(hotelSpa);
	}
	
	public void update(HotelSpa hotelSpa){
		hotelSpaDao.update(hotelSpa);
	}
	
	public void del(HotelSpa hotelSpa){
		hotelSpaDao.del(hotelSpa);
	}
}
