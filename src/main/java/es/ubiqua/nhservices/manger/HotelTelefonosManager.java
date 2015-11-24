package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelTelefonosDAO;
import es.ubiqua.nhservices.model.Hotel;
import es.ubiqua.nhservices.model.HotelTelefonos;

public class HotelTelefonosManager {
	
	private HotelTelefonosDAO hotelTelefonosDao = new HotelTelefonosDAO();
	
	public HotelTelefonosManager(){
		
	}
	
	public List<HotelTelefonos> listLang(int id){
		return hotelTelefonosDao.listLang(id);
	}
	
	public List<HotelTelefonos> listAll(){
		return hotelTelefonosDao.listAll();
	}
	
	public List<HotelTelefonos> list(Hotel h, String lang){
		return hotelTelefonosDao.list(h,lang);
	}

	public HotelTelefonos get(HotelTelefonos hotelTelefonos){
		return hotelTelefonosDao.get(hotelTelefonos);
	}
	
	public HotelTelefonos getTelefonosByIdAndLang(int id, String lang){
		return hotelTelefonosDao.getTelefonosByIdAndLang(id,lang);
	}
	
	public HotelTelefonos add(HotelTelefonos hotelTelefonos){
		return hotelTelefonosDao.add(hotelTelefonos);
	}
	
	public void update(HotelTelefonos hotelTelefonos){
		hotelTelefonosDao.update(hotelTelefonos);
	}
	
	public void del(HotelTelefonos hotelTelefonos){
		hotelTelefonosDao.del(hotelTelefonos);
	}
}
