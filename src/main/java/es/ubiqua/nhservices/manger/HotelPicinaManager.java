package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelPicinaDAO;
import es.ubiqua.nhservices.model.HotelCanales;
import es.ubiqua.nhservices.model.HotelPicina;

public class HotelPicinaManager {
	
	private HotelPicinaDAO hotelPicinaDao = new HotelPicinaDAO();
	
	public HotelPicinaManager(){
		
	}
	
	public List<HotelPicina> list(){
		return hotelPicinaDao.list();
	}

	public HotelPicina get(HotelPicina hotelPicina){
		return hotelPicinaDao.get(hotelPicina);
	}
	
	public HotelPicina add(HotelPicina hotelPicina){
		return hotelPicinaDao.add(hotelPicina);
	}
	
	public void update(HotelPicina hotelPicina){
		hotelPicinaDao.update(hotelPicina);
	}
	
	public void del(HotelPicina hotelPicina){
		hotelPicinaDao.del(hotelPicina);
	}
}
