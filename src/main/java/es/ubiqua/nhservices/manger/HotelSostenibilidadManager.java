package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelSostenibilidadDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelSostenibilidad;

public class HotelSostenibilidadManager {
	
	private HotelSostenibilidadDAO hotelSostenibilidadDao = new HotelSostenibilidadDAO();
	
	public HotelSostenibilidadManager(){
		
	}
	
	public List<HotelSostenibilidad> list(Hotel h, String lang){
		return hotelSostenibilidadDao.list(h,lang);
	}

	public HotelSostenibilidad get(HotelSostenibilidad hotelSostenibilidad){
		return hotelSostenibilidadDao.get(hotelSostenibilidad);
	}
	
	public HotelSostenibilidad add(HotelSostenibilidad hotelSostenibilidad){
		return hotelSostenibilidadDao.add(hotelSostenibilidad);
	}
	
	public void update(HotelSostenibilidad hotelSostenibilidad){
		hotelSostenibilidadDao.update(hotelSostenibilidad);
	}
	
	public void del(HotelSostenibilidad hotelSostenibilidad){
		hotelSostenibilidadDao.del(hotelSostenibilidad);
	}
}
