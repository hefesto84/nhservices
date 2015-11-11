package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelSeguridadDAO;
import es.ubiqua.nhservices.model.HotelSeguridad;

public class HotelSeguridadManager {
	
	private HotelSeguridadDAO hotelSeguridadDao = new HotelSeguridadDAO();
	
	public HotelSeguridadManager(){
		
	}
	
	public List<HotelSeguridad> list(){
		return hotelSeguridadDao.list();
	}

	public HotelSeguridad get(HotelSeguridad hotelSeguridad){
		return hotelSeguridadDao.get(hotelSeguridad);
	}
	
	public HotelSeguridad add(HotelSeguridad hotelSeguridad){
		return hotelSeguridadDao.add(hotelSeguridad);
	}
}
