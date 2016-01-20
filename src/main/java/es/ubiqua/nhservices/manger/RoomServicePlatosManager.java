package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServicePlatosDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.RoomServicePlatos;

public class RoomServicePlatosManager {
	
	private RoomServicePlatosDAO roomServicePlatosDao = new RoomServicePlatosDAO();
	
	public RoomServicePlatosManager(){
		
	}
	
	public List<RoomServicePlatos> list(Hotel h, String lang){
		return roomServicePlatosDao.list(h,lang);
	}

	/*public HotelDirectoryRestaurantes get(HotelDirectoryRestaurantes hotelDirectoryRestaurantes){
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
	}*/
}
