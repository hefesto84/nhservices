package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryServiciosDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelDirectoryServicios;

public class HotelDirectoryServiciosManager {
	
	private HotelDirectoryServiciosDAO hotelDirectoryServiciosDao = new HotelDirectoryServiciosDAO();
	
	public HotelDirectoryServiciosManager(){
		
	}
	
	public List<HotelDirectoryServicios> list(Hotel h, String lang){
		return hotelDirectoryServiciosDao.list(h,lang);
	}

	public HotelDirectoryServicios get(HotelDirectoryServicios hotelDirectoryServicios){
		return hotelDirectoryServiciosDao.get(hotelDirectoryServicios);
	}
	
	public HotelDirectoryServicios add(HotelDirectoryServicios hotelDirectoryServicios){
		return hotelDirectoryServiciosDao.add(hotelDirectoryServicios);
	}
	
	public void update(HotelDirectoryServicios hotelDirectoryServicios){
		hotelDirectoryServiciosDao.update(hotelDirectoryServicios);
	}
	
	public void del(HotelDirectoryServicios hotelDirectoryServicios){
		hotelDirectoryServiciosDao.del(hotelDirectoryServicios);
	}
}
