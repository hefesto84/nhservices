package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDesayunoDAO;
import es.ubiqua.nhservices.model.HotelDesayuno;

public class HotelDesayunoManager {
	
	private HotelDesayunoDAO hotelDesayunoDao = new HotelDesayunoDAO();
	
	public HotelDesayunoManager(){
		
	}
	
	public List<HotelDesayuno> list(){
		return hotelDesayunoDao.list();
	}

	public HotelDesayuno get(HotelDesayuno hotelDesayuno){
		return hotelDesayunoDao.get(hotelDesayuno);
	}
	
	public HotelDesayuno add(HotelDesayuno hotelDesayuno){
		return hotelDesayunoDao.add(hotelDesayuno);
	}
	
	public void update(HotelDesayuno hotelDesayuno){
		hotelDesayunoDao.update(hotelDesayuno);
	}
	
	public void del(HotelDesayuno hotelDesayuno){
		hotelDesayunoDao.del(hotelDesayuno);
	}
}