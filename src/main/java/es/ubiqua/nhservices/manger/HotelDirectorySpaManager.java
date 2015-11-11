package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectorySpaDAO;
import es.ubiqua.nhservices.model.HotelDirectorySpa;

public class HotelDirectorySpaManager {
	
	private HotelDirectorySpaDAO hotelDirectorySpaDao = new HotelDirectorySpaDAO();
	
	public HotelDirectorySpaManager(){
		
	}
	
	public List<HotelDirectorySpa> list(){
		return hotelDirectorySpaDao.list();
	}

	public HotelDirectorySpa get(HotelDirectorySpa hotelDirectorySpa){
		return hotelDirectorySpaDao.get(hotelDirectorySpa);
	}
	
	public HotelDirectorySpa add(HotelDirectorySpa hotelDirectorySpa){
		return hotelDirectorySpaDao.add(hotelDirectorySpa);
	}
}
