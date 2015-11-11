package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryGimnasioDAO;
import es.ubiqua.nhservices.model.HotelDirectoryGimnasio;

public class HotelDirectoryGimnasioManager {
	
	private HotelDirectoryGimnasioDAO hotelDirectoryGimnasioDao = new HotelDirectoryGimnasioDAO();
	
	public HotelDirectoryGimnasioManager(){
		
	}
	
	public List<HotelDirectoryGimnasio> list(){
		return hotelDirectoryGimnasioDao.list();
	}

	public HotelDirectoryGimnasio get(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		return hotelDirectoryGimnasioDao.get(hotelDirectoryGimnasio);
	}
	
	public HotelDirectoryGimnasio add(HotelDirectoryGimnasio hotelDirectoryGimnasio){
		return hotelDirectoryGimnasioDao.add(hotelDirectoryGimnasio);
	}
}
