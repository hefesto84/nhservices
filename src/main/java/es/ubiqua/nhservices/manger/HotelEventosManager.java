package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelEventosDAO;
import es.ubiqua.nhservices.model.HotelEventos;

public class HotelEventosManager {
	
	private HotelEventosDAO hotelEventosDao = new HotelEventosDAO();
	
	public HotelEventosManager(){
		
	}
	
	public List<HotelEventos> list(){
		return hotelEventosDao.list();
	}

	public HotelEventos get(HotelEventos hotelEventos){
		return hotelEventosDao.get(hotelEventos);
	}
	
	public HotelEventos add(HotelEventos hotelEventos){
		return hotelEventosDao.add(hotelEventos);
	}
}
