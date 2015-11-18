package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectorySpaDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectorySpa;

public class HotelDirectorySpaManager {
	
	private HotelDirectorySpaDAO hotelDirectorySpaDao = new HotelDirectorySpaDAO();
	
	public HotelDirectorySpaManager(){
		
	}
	
	public List<HotelDirectorySpa> list(Hotel h, String lang){
		return hotelDirectorySpaDao.list(h,lang);
	}

	public HotelDirectorySpa get(HotelDirectorySpa hotelDirectorySpa){
		return hotelDirectorySpaDao.get(hotelDirectorySpa);
	}
	
	public HotelDirectorySpa add(HotelDirectorySpa hotelDirectorySpa){
		return hotelDirectorySpaDao.add(hotelDirectorySpa);
	}
	
	public void update(HotelDirectorySpa hotelDirectorySpa){
		hotelDirectorySpaDao.update(hotelDirectorySpa);
	}
	
	public void del(HotelDirectorySpa hotelDirectorySpa){
		hotelDirectorySpaDao.del(hotelDirectorySpa);
	}
}
