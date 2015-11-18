package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryRestauranteDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryRestaurantes;

public class HotelDirectoryRestauranteManager {
	
	private HotelDirectoryRestauranteDAO hotelDirectoryRestauranteDao = new HotelDirectoryRestauranteDAO();
	
	public HotelDirectoryRestauranteManager(){
		
	}
	
	public List<HotelDirectoryRestaurantes> list(Hotel h, String lang){
		return hotelDirectoryRestauranteDao.list(h,lang);
	}

	public HotelDirectoryRestaurantes get(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		return hotelDirectoryRestauranteDao.get(hotelDirectoryRestaurantes);
	}
	
	public HotelDirectoryRestaurantes add(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		return hotelDirectoryRestauranteDao.add(hotelDirectoryRestaurantes);
	}
	
	public void update(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		hotelDirectoryRestauranteDao.update(hotelDirectoryRestaurantes);
	}
	
	public void del(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
		hotelDirectoryRestauranteDao.del(hotelDirectoryRestaurantes);
	}
}
