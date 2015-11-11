package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelRestauranteDAO;
import es.ubiqua.nhservices.model.HotelRestaurante;

public class HotelRestauranteManager {
	
	private HotelRestauranteDAO hotelRestauranteDao = new HotelRestauranteDAO();
	
	public HotelRestauranteManager(){
		
	}
	
	public List<HotelRestaurante> list(){
		return hotelRestauranteDao.list();
	}

	public HotelRestaurante get(HotelRestaurante hotelRestaurante){
		return hotelRestauranteDao.get(hotelRestaurante);
	}
	
	public HotelRestaurante add(HotelRestaurante hotelRestaurante){
		return hotelRestauranteDao.add(hotelRestaurante);
	}
}
