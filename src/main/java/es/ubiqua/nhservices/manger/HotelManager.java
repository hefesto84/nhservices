package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDAO;
import es.ubiqua.nhservices.model.Hotel;

public class HotelManager {
	
	private HotelDAO hotelDao = new HotelDAO();
	
	public HotelManager(){
		
	}
	
	public List<Hotel> list(){
		return hotelDao.list();
	}

	public Hotel get(Hotel hotel){
		return hotelDao.get(hotel);
	}
	
	public Hotel add(Hotel hotel){
		return hotelDao.add(hotel);
	}
	
	public void update(Hotel hotel){
		hotelDao.update(hotel);
	}
	
	public void del(Hotel hotel){
		hotelDao.del(hotel);
	}
}
