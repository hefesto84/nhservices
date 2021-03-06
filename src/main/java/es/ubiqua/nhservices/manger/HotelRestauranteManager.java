package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelRestauranteDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelRestaurante;

public class HotelRestauranteManager {
	
	private HotelRestauranteDAO hotelRestauranteDao = new HotelRestauranteDAO();
	
	public HotelRestauranteManager(){
		
	}
	
	public List<HotelRestaurante> list(Hotel h){
		return hotelRestauranteDao.list(h);
	}

	public HotelRestaurante get(HotelRestaurante hotelRestaurante){
		return hotelRestauranteDao.get(hotelRestaurante);
	}
	
	public HotelRestaurante add(HotelRestaurante hotelRestaurante){
		return hotelRestauranteDao.add(hotelRestaurante);
	}
	
	public void update(HotelRestaurante hotelRestaurante){
		hotelRestauranteDao.update(hotelRestaurante);
	}
	
	public void del(HotelRestaurante hotelRestaurante){
		hotelRestauranteDao.del(hotelRestaurante);
	}
}
