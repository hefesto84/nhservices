package es.ubiqua.nhservices.manger;

import java.util.List;

import es.ubiqua.nhservices.dao.HotelDirectoryWifiDAO;
import es.ubiqua.nhservices.model.HotelDirectoryWifi;

public class HotelDirectoryWifiManager {
	
	private HotelDirectoryWifiDAO hotelDirectoryWifiDao = new HotelDirectoryWifiDAO();
	
	public HotelDirectoryWifiManager(){
		
	}
	
	public List<HotelDirectoryWifi> list(){
		return hotelDirectoryWifiDao.list();
	}

	public HotelDirectoryWifi get(HotelDirectoryWifi hotelDirectoryWifi){
		return hotelDirectoryWifiDao.get(hotelDirectoryWifi);
	}
	
	public HotelDirectoryWifi add(HotelDirectoryWifi hotelDirectoryWifi){
		return hotelDirectoryWifiDao.add(hotelDirectoryWifi);
	}
}
