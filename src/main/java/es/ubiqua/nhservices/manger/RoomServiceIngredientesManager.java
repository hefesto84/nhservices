package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.RoomServiceIngredientesDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.RoomServiceIngredientes;

public class RoomServiceIngredientesManager {
	
	private RoomServiceIngredientesDAO roomServiceIngredientesDao = new RoomServiceIngredientesDAO();
	
	public RoomServiceIngredientesManager(){
		
	}
	
	public List<RoomServiceIngredientes> list(Hotel h, String lang){
		return roomServiceIngredientesDao.list(h,lang);
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
