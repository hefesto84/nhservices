package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelServiciosDAO;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelServicios;

public class HotelServiciosManager {
	
	private HotelServiciosDAO hotelServiciosDao = new HotelServiciosDAO();
	
	public HotelServiciosManager(){
		
	}
	
	public List<HotelServicios> list(){
		return hotelServiciosDao.list();
	}

	public HotelServicios get(HotelServicios hotelServicios){
		return hotelServiciosDao.get(hotelServicios);
	}
	
	public HotelServicios add(HotelServicios hotelServicios){
		return hotelServiciosDao.add(hotelServicios);
	}
	
	public void update(HotelServicios hotelServicios){
		hotelServiciosDao.update(hotelServicios);
	}
	
	public void del(HotelServicios hotelServicios){
		hotelServiciosDao.del(hotelServicios);
	}
}
