package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelCanalesDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelCanales;

public class HotelCanalesManager {
	
	private HotelCanalesDAO hotelCanalesDao = new HotelCanalesDAO();
	
	public HotelCanalesManager(){
		
	}
	
	public List<HotelCanales> listLang(int id){
		return hotelCanalesDao.listLang(id);
	}
	
	public List<HotelCanales> listAll(){
		return hotelCanalesDao.listAll();
	}
	
	public List<HotelCanales> list(Hotel h, String lang){
		return hotelCanalesDao.list(h,lang);
	}

	public HotelCanales get(HotelCanales hotelCanales){
		return hotelCanalesDao.get(hotelCanales);
	}
	
	public HotelCanales getCanalByIdAndLang(int id, String lang){
		return hotelCanalesDao.getCanalByIdAndLang(id,lang);
	}
	
	public HotelCanales add(HotelCanales hotelCanales){
		return hotelCanalesDao.add(hotelCanales);
	}
	
	public void update(HotelCanales hotelCanales){
		hotelCanalesDao.update(hotelCanales);
	}
	
	public void del(HotelCanales hotelCanales){
		hotelCanalesDao.del(hotelCanales);
	}
	
}
