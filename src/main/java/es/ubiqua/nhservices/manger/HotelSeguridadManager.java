package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelSeguridadDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelSeguridad;

public class HotelSeguridadManager {
	
	private HotelSeguridadDAO hotelSeguridadDao = new HotelSeguridadDAO();
	
	public HotelSeguridadManager(){
		
	}
	
	public List<HotelSeguridad> listLang(int id){
		return hotelSeguridadDao.listLang(id);
	}
	
	public List<HotelSeguridad> listAll(){
		return hotelSeguridadDao.listAll();
	}
	
	public List<HotelSeguridad> list(Hotel h, String lang){
		return hotelSeguridadDao.list(h,lang);
	}

	public HotelSeguridad get(HotelSeguridad hotelSeguridad){
		return hotelSeguridadDao.get(hotelSeguridad);
	}
	
	public HotelSeguridad getSeguridadByIdAndLang(int id, String lang){
		return hotelSeguridadDao.getSeguridadByIdAndLang(id,lang);
	}
	
	public HotelSeguridad add(HotelSeguridad hotelSeguridad){
		return hotelSeguridadDao.add(hotelSeguridad);
	}
	
	public void update(HotelSeguridad hotelSeguridad){
		hotelSeguridadDao.update(hotelSeguridad);
	}
	
	public void del(HotelSeguridad hotelSeguridad){
		hotelSeguridadDao.del(hotelSeguridad);
	}
}
