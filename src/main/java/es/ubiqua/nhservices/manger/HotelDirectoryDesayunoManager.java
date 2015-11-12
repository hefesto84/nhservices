package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryDesayunoDAO;
import es.ubiqua.nhservices.model.HotelDirectoryDesayuno;

public class HotelDirectoryDesayunoManager {
	
	private HotelDirectoryDesayunoDAO hotelDirectoryDesayunoDao = new HotelDirectoryDesayunoDAO();
	
	public HotelDirectoryDesayunoManager(){
		
	}
	
	public List<HotelDirectoryDesayuno> list(){
		return hotelDirectoryDesayunoDao.list();
	}

	public HotelDirectoryDesayuno get(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		return hotelDirectoryDesayunoDao.get(hotelDirectoryDesayuno);
	}
	
	public HotelDirectoryDesayuno add(HotelDirectoryDesayuno hotelDirectoryDesayuno){
		return hotelDirectoryDesayunoDao.add(hotelDirectoryDesayuno);
	}
}