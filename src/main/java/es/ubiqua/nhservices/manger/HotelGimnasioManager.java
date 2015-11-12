package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelGimnasioDAO;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelGimnasio;

public class HotelGimnasioManager {
	
	private HotelGimnasioDAO hotelGimnasioDao = new HotelGimnasioDAO();
	
	public HotelGimnasioManager(){
		
	}
	
	public List<HotelGimnasio> list(){
		return hotelGimnasioDao.list();
	}

	public HotelGimnasio get(HotelGimnasio hotelGimnasio){
		return hotelGimnasioDao.get(hotelGimnasio);
	}
	
	public HotelGimnasio add(HotelGimnasio hotelGimnasio){
		return hotelGimnasioDao.add(hotelGimnasio);
	}
	
	public void update(HotelGimnasio hotelGimnasio){
		hotelGimnasioDao.update(hotelGimnasio);
	}
	
	public void del(HotelGimnasio hotelGimnasio){
		hotelGimnasioDao.del(hotelGimnasio);
	}
}
