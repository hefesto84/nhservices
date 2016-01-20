package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServiceBebidasDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.RoomServiceBebidas;

public class RoomServiceBebidasManager {
	
	private RoomServiceBebidasDAO roomServiceBebidasDao = new RoomServiceBebidasDAO();
	
	public RoomServiceBebidasManager(){
		
	}
	
	public List<RoomServiceBebidas> list(Hotel h, String lang){
		return roomServiceBebidasDao.list(h,lang);
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
