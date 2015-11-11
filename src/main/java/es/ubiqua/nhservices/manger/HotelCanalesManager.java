package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelCanalesDAO;
import es.ubiqua.nhservices.model.HotelCanales;

public class HotelCanalesManager {
	
	private HotelCanalesDAO hotelCanalesDao = new HotelCanalesDAO();
	
	public HotelCanalesManager(){
		
	}
	
	public List<HotelCanales> list(){
		return hotelCanalesDao.list();
	}

	public HotelCanales get(HotelCanales hotelCanales){
		return hotelCanalesDao.get(hotelCanales);
	}
	
	public HotelCanales add(HotelCanales hotelCanales){
		return hotelCanalesDao.add(hotelCanales);
	}
}
