package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryGimnasioDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelDirectoryGimnasio;

public class HotelDirectoryGimnasioManager {
	
	private HotelDirectoryGimnasioDAO hotelDirectoryGimnasioDao = new HotelDirectoryGimnasioDAO();
	
	public HotelDirectoryGimnasioManager(){
		
	}
	
	public List<HotelDirectoryGimnasio> list(Hotel h, String lang){
		return hotelDirectoryGimnasioDao.list(h,lang);
	}

	public HotelDirectoryGimnasio get(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		return hotelDirectoryGimnasioDao.get(hotelDirectoryGimnasio);
	}
	
	public HotelDirectoryGimnasio add(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		return hotelDirectoryGimnasioDao.add(hotelDirectoryGimnasio);
	}
	
	public void update(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		hotelDirectoryGimnasioDao.update(hotelDirectoryGimnasio);
	}
	
	public void del(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		hotelDirectoryGimnasioDao.del(hotelDirectoryGimnasio);
	}
}
