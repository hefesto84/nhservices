package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelWifiDAO;
import es.ubiqua.nhservices.model.HotelWifi;

public class HotelWifiManager {
	
	private HotelWifiDAO hotelWifiDao = new HotelWifiDAO();
	
	public HotelWifiManager(){
		
	}
	
	public List<HotelWifi> list(){
		return hotelWifiDao.list();
	}

	public HotelWifi get(HotelWifi hotelWifi){
		return hotelWifiDao.get(hotelWifi);
	}
	
	public HotelWifi add(HotelWifi hotelWifi){
		return hotelWifiDao.add(hotelWifi);
	}
	
	public void update(HotelWifi hotelWifi){
		hotelWifiDao.update(hotelWifi);
	}
	
	public void del(HotelWifi hotelWifi){
		hotelWifiDao.del(hotelWifi);
	}
}
