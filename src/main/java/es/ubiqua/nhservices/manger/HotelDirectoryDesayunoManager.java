package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryDesayunoDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelDirectoryDesayuno;

public class HotelDirectoryDesayunoManager {
	
	private HotelDirectoryDesayunoDAO hotelDirectoryDesayunoDao = new HotelDirectoryDesayunoDAO();
	
	public HotelDirectoryDesayunoManager(){
		
	}
	
	public List<HotelDirectoryDesayuno> list(Hotel h, String lang){
		return hotelDirectoryDesayunoDao.list(h,lang);
	}

	public HotelDirectoryDesayuno get(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		return hotelDirectoryDesayunoDao.get(hotelDirectoryDesayuno);
	}
	
	public HotelDirectoryDesayuno add(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		return hotelDirectoryDesayunoDao.add(hotelDirectoryDesayuno);
	}
	
	public void update(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		hotelDirectoryDesayunoDao.update(hotelDirectoryDesayuno);
	}
	
	public void del(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		hotelDirectoryDesayunoDao.del(hotelDirectoryDesayuno);
	}
}
