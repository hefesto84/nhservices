package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryPicinaDAO;
import es.ubiqua.nhservices.model.HotelDirectoryPicina;

public class HotelDirectoryPicinaManager {
	
	private HotelDirectoryPicinaDAO hotelDirectoryPicinaDao = new HotelDirectoryPicinaDAO();
	
	public HotelDirectoryPicinaManager(){
		
	}
	
	public List<HotelDirectoryPicina> list(){
		return hotelDirectoryPicinaDao.list();
	}

	public HotelDirectoryPicina get(HotelDirectoryPicina hotelDirectoryPicina){
		return hotelDirectoryPicinaDao.get(hotelDirectoryPicina);
	}
	
	public HotelDirectoryPicina add(HotelDirectoryPicina hotelDirectoryPicina){
		return hotelDirectoryPicinaDao.add(hotelDirectoryPicina);
	}
}
