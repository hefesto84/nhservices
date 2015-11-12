package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryEventosDAO;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelDirectoryEventos;

public class HotelDirectoryEventosManager {
	
	private HotelDirectoryEventosDAO hotelDirectoryEventosDao = new HotelDirectoryEventosDAO();
	
	public HotelDirectoryEventosManager(){
		
	}
	
	public List<HotelDirectoryEventos> list(){
		return hotelDirectoryEventosDao.list();
	}

	public HotelDirectoryEventos get(HotelDirectoryEventos hotelDirectoryEventos){
		return hotelDirectoryEventosDao.get(hotelDirectoryEventos);
	}
	
	public HotelDirectoryEventos add(HotelDirectoryEventos hotelDirectoryEventos){
		return hotelDirectoryEventosDao.add(hotelDirectoryEventos);
	}
	
	public void update(HotelDirectoryEventos hotelDirectoryEventos){
		hotelDirectoryEventosDao.update(hotelDirectoryEventos);
	}
	
	public void del(HotelDirectoryEventos hotelDirectoryEventos){
		hotelDirectoryEventosDao.del(hotelDirectoryEventos);
	}
}
