package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelSostenibilidadDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelSostenibilidad;

public class HotelSostenibilidadManager {
	
	private HotelSostenibilidadDAO hotelSostenibilidadDao = new HotelSostenibilidadDAO();
	
	public HotelSostenibilidadManager(){
		
	}
	
	public List<HotelSostenibilidad> listLang(int id){
		return hotelSostenibilidadDao.listLang(id);
	}
	
	public List<HotelSostenibilidad> listAll(){
		return hotelSostenibilidadDao.listAll();
	}
	
	public List<HotelSostenibilidad> list(Hotel h, String lang){
		return hotelSostenibilidadDao.list(h,lang);
	}

	public HotelSostenibilidad get(HotelSostenibilidad hotelSostenibilidad){
		return hotelSostenibilidadDao.get(hotelSostenibilidad);
	}
	
	public HotelSostenibilidad getSostenibilidadByIdAndLang(int id, String lang){
		return hotelSostenibilidadDao.getSostenibilidadByIdAndLang(id,lang);
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
