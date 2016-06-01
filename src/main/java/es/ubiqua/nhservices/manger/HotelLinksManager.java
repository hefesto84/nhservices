package es.ubiqua.nhservices.manger;


import java.util.List;

import es.ubiqua.nhservices.dao.HotelLinksDAO;
import es.ubiqua.nhservices.model.HotelLinks;

public class HotelLinksManager {
	
	private HotelLinksDAO hotelLinksDao = new HotelLinksDAO();
	
	public HotelLinksManager(){
		
	}
	
	public List<HotelLinks> list(){
		return hotelLinksDao.list();
	}

}
