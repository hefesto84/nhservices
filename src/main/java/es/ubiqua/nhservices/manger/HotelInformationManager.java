package es.ubiqua.nhservices.manger;


import java.util.List;

import es.ubiqua.nhservices.dao.HotelInformationDAO;
import es.ubiqua.nhservices.model.HotelInformation;

public class HotelInformationManager {
	
	private HotelInformationDAO hotelInformationDao = new HotelInformationDAO();
	
	public HotelInformationManager(){
		
	}
	
	public List<HotelInformation> list(){
		return hotelInformationDao.list();
	}

}
