package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelTelefonosDAO;
import es.ubiqua.nhservices.model.HotelTelefonos;

public class HotelTelefonosManager {
	
	private HotelTelefonosDAO hotelTelefonosDao = new HotelTelefonosDAO();
	
	public HotelTelefonosManager(){
		
	}
	
	public List<HotelTelefonos> list(){
		return hotelTelefonosDao.list();
	}

	public HotelTelefonos get(HotelTelefonos hotelTelefonos){
		return hotelTelefonosDao.get(hotelTelefonos);
	}
	
	public HotelTelefonos add(HotelTelefonos hotelTelefonos){
		return hotelTelefonosDao.add(hotelTelefonos);
	}
}
