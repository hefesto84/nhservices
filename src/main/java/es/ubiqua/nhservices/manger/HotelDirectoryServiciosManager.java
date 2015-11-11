package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryServiciosDAO;
import es.ubiqua.nhservices.model.HotelDirectoryServicios;

public class HotelDirectoryServiciosManager {
	
	private HotelDirectoryServiciosDAO hotelDirectoryServiciosDao = new HotelDirectoryServiciosDAO();
	
	public HotelDirectoryServiciosManager(){
		
	}
	
	public List<HotelDirectoryServicios> list(){
		return hotelDirectoryServiciosDao.list();
	}

	public HotelDirectoryServicios get(HotelDirectoryServicios hotelDirectoryServicios){
		return hotelDirectoryServiciosDao.get(hotelDirectoryServicios);
	}
	
	public HotelDirectoryServicios add(HotelDirectoryServicios hotelDirectoryServicios){
		return hotelDirectoryServiciosDao.add(hotelDirectoryServicios);
	}
}
