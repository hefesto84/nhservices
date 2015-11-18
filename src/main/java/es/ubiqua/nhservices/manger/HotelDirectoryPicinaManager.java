package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryPicinaDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryPicina;

public class HotelDirectoryPicinaManager {
	
	private HotelDirectoryPicinaDAO hotelDirectoryPicinaDao = new HotelDirectoryPicinaDAO();
	
	public HotelDirectoryPicinaManager(){
		
	}
	
	public List<HotelDirectoryPicina> list(Hotel h, String lang){
		return hotelDirectoryPicinaDao.list(h,lang);
	}

	public HotelDirectoryPicina get(HotelDirectoryPicina hotelDirectoryPicina){
		return hotelDirectoryPicinaDao.get(hotelDirectoryPicina);
	}
	
	public HotelDirectoryPicina add(HotelDirectoryPicina hotelDirectoryPicina){
		return hotelDirectoryPicinaDao.add(hotelDirectoryPicina);
	}
	
	public void update(HotelDirectoryPicina hotelDirectoryPicina){
		hotelDirectoryPicinaDao.update(hotelDirectoryPicina);
	}
	
	public void del(HotelDirectoryPicina hotelDirectoryPicina){
		hotelDirectoryPicinaDao.del(hotelDirectoryPicina);
	}
}
